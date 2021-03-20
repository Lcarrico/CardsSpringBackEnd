package dev.carrico.controllers;

import dev.carrico.entities.Learner;
import dev.carrico.services.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Component
@RestController
public class LearnerController {
    @Autowired
    LearnerService learnerService;

    @PostMapping("/learners")
    @ResponseBody
    public Learner createLearner(@RequestBody Learner learner){
        this.learnerService.createLearner(learner);
        return learner;
    }

    @GetMapping("/learners/{learnerId}")
    @ResponseBody
    public Learner getLearnerById(@PathVariable int learnerId){
        Learner learner = this.learnerService.getLearnerById(learnerId);
        return learner;
    }

    @GetMapping("/learners")
    @ResponseBody
    public Set<Learner> getLearners(@RequestParam(name = "username",defaultValue = "") String username){
        Set<Learner> learners;
        if (username.isEmpty()){
            learners = this.learnerService.getAllLearners();
        }
        else{
            learners = new HashSet<>();
            learners.add(this.learnerService.getLearnerByUsername(username));
        }
        return learners;
    }

    @PutMapping("/learners/{learnerId}")
    @ResponseBody
    public Learner updateLearner(@PathVariable int learnerId, @RequestBody Learner learner){
        learner.setLearnerId(learnerId);
        this.learnerService.updateLearner(learner);
        return learner;
    }

    @DeleteMapping("/learners/{learnerId}")
    @ResponseBody
    public Boolean deleteBookById(@PathVariable int learnerId){
        Boolean result = this.learnerService.deleteLearnerById(learnerId);
        return result;
    }
}
