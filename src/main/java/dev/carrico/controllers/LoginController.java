package dev.carrico.controllers;

import dev.carrico.entities.Learner;
import dev.carrico.services.LearnerService;
import dev.carrico.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Component
@RestController
public class LoginController {

    @Autowired
    LearnerService learnerService;

    @ResponseBody
    @CrossOrigin
    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> loginLearner(@RequestBody Learner learner){
        Learner loggedInLearner = learnerService.getLearnerByUsername(learner.getUsername());

        if (loggedInLearner != null && loggedInLearner.getPassword().equals(learner.getPassword())){
            return ResponseEntity
                    .status(200)
                    .body(JwtUtil.generate(loggedInLearner.getUsername(),
                                          loggedInLearner.getLearnerId()));
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
