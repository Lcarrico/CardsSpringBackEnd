package dev.carrico.controllers;

import com.auth0.jwt.interfaces.DecodedJWT;
import dev.carrico.entities.Learner;
import dev.carrico.services.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static dev.carrico.utils.JwtUtil.isValidJWT;

@Component
@RestController
@CrossOrigin
public class LearnerController {
    @Autowired
    LearnerService learnerService;

    @PostMapping("/learners")
    public ResponseEntity createLearner(@RequestBody Learner learner){
        try{
            if(this.learnerService.getLearnerByUsername(learner.getUsername()) != null){
                throw new DuplicateKeyException("Username already in use");
            }
            return ResponseEntity.status(200).body(this.learnerService.createLearner(learner));
        }catch (DuplicateKeyException e){
            return ResponseEntity.status(405).body("There already exists an account with that username. Please try again.");
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body("Something went wrong with the account creation process.");
        }
    }

    @GetMapping("/learners/{learnerId}")
    public ResponseEntity<Learner> getLearnerById(@PathVariable int learnerId){
        Learner learner = this.learnerService.getLearnerById(learnerId);
        learner.setPassword("");
        return ResponseEntity.status(200).body(learner);
    }

    @GetMapping("/learners")
    public ResponseEntity<Set<Learner>> getLearners(@RequestParam(name = "username",defaultValue = "") String username){
        Set<Learner> learners;
        if (username.isEmpty()){
            learners = this.learnerService.getAllLearners();
        }
        else{
            learners = new HashSet<>();
            learners.add(this.learnerService.getLearnerByUsername(username));
        }
        for (Learner learner: learners) {
            learner.setPassword("");
        };
        return ResponseEntity.status(200).body(learners);
    }

    @PutMapping("/learners/{learnerId}")
    public ResponseEntity updateLearner(@PathVariable int learnerId, @RequestBody Learner learner) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        String auth = request.getHeader("Authorization");

        if (auth != null) {
            DecodedJWT jwt = isValidJWT(auth);
            int loggedInLearnerId = Integer.parseInt(jwt.getClaim("id").toString());

            if (loggedInLearnerId == learnerId) {
                learner.setLearnerId(learnerId);
                this.learnerService.updateLearner(learner);
                return ResponseEntity.status(200).body(learner);
            }
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You can only update your own account.");
    }

    @DeleteMapping("/learners/{learnerId}")
    public ResponseEntity<Boolean> deleteLearnerById(@PathVariable int learnerId){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String auth = request.getHeader("Authorization");

        if (auth != null) {
            DecodedJWT jwt = isValidJWT(auth);
            int loggedInLearnerId = jwt.getClaim("learnerId").asInt();

            if (loggedInLearnerId == learnerId) {
                Boolean result = this.learnerService.deleteLearnerById(learnerId);
                return ResponseEntity.status(200).body(result);
            }
        }
        return ResponseEntity.status(200).body(false);
    }
}
