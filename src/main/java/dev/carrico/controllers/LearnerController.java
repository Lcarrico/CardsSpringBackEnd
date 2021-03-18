package dev.carrico.controllers;

import dev.carrico.entities.Learner;
import dev.carrico.services.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
public class LearnerController {
    @Autowired
    LearnerService learnerService;

    @PostMapping("/learners")
    public Learner createLearner(@RequestBody Learner learner){
        this.learnerService.createLearner(learner);
        return learner;
    }

    @GetMapping("/learners/{learnerId}")
    public Learner getLearnerById(@PathVariable int learnerId){
        Learner learner = this.learnerService.getLearnerById(learnerId);
        return learner;
    }

    @GetMapping("/learners")
    public Set<Learner> getAllLearners(){
        Set<Learner> learners = this.learnerService.getAllLearners();
        return learners;
    }

    @PutMapping("/learners/{learnerId}")
    public Learner updateLearner(@PathVariable int learnerId, @RequestBody Learner learner){
        learner.setLearnerId(learnerId);
        this.learnerService.updateLearner(learner);
        return learner;
    }

    @DeleteMapping("/learners/{learnerId}")
    public Boolean deleteBookById(@PathVariable int learnerId){
        Boolean result = this.learnerService.deleteLearnerById(learnerId);
        return result;
    }

    // TODO add stack to learner

    // TODO remove stack from learner
}
