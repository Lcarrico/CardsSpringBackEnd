package dev.carrico.aspects;

import dev.carrico.entities.Learner;
import dev.carrico.services.LearnerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static dev.carrico.utils.JwtUtil.isValidJWT;

@Component
@Aspect
public class SecurityAspect {

    @Autowired
    LearnerService ls;

    @Around("authorizeJP()")
    public Object authenticate(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        String auth = request.getHeader("Authorization");
        System.out.println(auth);
        System.out.println(pjp.getSignature().toString());

        if (auth != null) {
            String loggedInLearner = isValidJWT(auth).getClaim("username").toString();

            Learner learner = ls.getLearnerByUsername(loggedInLearner);
            if (learner != null && learner.getUsername() == loggedInLearner) {
                Object obj = pjp.proceed();
                return obj;
            }
        }
        response.sendError(401);
        return null;
    }

    @Around("adminJP()")
    public Object adminsOnly(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        String auth = request.getHeader("Authorization");
        System.out.println(auth);
        System.out.println(pjp.getSignature().toString());

        if (auth != null) {
            String loggedInLearner = isValidJWT(auth).getClaim("username").toString();
            int learnerId = isValidJWT(auth).getClaim("learnerId").asInt();

            String[] admins = {"carrico", "TestAccount"};
            Learner learner = ls.getLearnerByUsername(loggedInLearner);
            if (learner != null) {
                for (String admin: admins){
                    if (admin.equals(loggedInLearner)){
                        Object obj = pjp.proceed();
                        return obj;
                    }
                }
            }
        }
        response.sendError(401);
        return null;
    }

    @Pointcut("@annotation(dev.carrico.aspects.Authorized)")
    private void authorizeJP(){ }

    @Pointcut("@annotation(dev.carrico.aspects.Admin)")
    private void adminJP(){ }
}
