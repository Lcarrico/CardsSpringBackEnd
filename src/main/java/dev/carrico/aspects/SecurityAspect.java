package dev.carrico.aspects;

import dev.carrico.entities.Learner;
import dev.carrico.services.LearnerService;
import org.apache.log4j.Logger;
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

    private static Logger logger = Logger.getLogger(LoggingAspect.class);

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
            if (loggedInLearner.startsWith("\"")) {
                loggedInLearner = loggedInLearner.substring(1);
            }
            if (loggedInLearner.endsWith("\"")) {
                loggedInLearner = loggedInLearner.substring(0, loggedInLearner.length() - 1);
            }
            Learner learner = ls.getLearnerByUsername(loggedInLearner);
            if (learner != null && learner.getUsername().equals(loggedInLearner)) {
                Object obj = pjp.proceed();
                return obj;
            }
        }
        logger.error("Learner not logged in to perform action.");
        response.sendError(401, "Please make sure you are logged in to perform this action.");
        return null;
    }

    @Pointcut("@annotation(dev.carrico.aspects.Authorized)")
    private void authorizeJP(){ }
}
