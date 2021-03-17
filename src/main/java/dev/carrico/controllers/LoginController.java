package dev.carrico.controllers;

import dev.carrico.entities.Card;
import dev.carrico.entities.Learner;
import dev.carrico.services.LearnerService;
import dev.carrico.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Component
@RestController
public class LoginController {

    @Autowired
    LearnerService learnerService;

    @PostMapping("/login")
    public String loginLearner(@RequestBody Learner learner){
        Learner loggedInLearner = learnerService.getByUsernameAndPassword(learner.getUsername(), learner.getPassword());

        if (loggedInLearner != null){
            return JwtUtil.generate(loggedInLearner.getUsername(), loggedInLearner.getLearnerId());
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
