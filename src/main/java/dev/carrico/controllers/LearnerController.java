package dev.carrico.controllers;

import dev.carrico.entities.Learner;
import dev.carrico.entities.Stack;
import dev.carrico.services.LearnerService;
import dev.carrico.services.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
public class LearnerController {
    @Autowired
    LearnerService learnerService;

    @Autowired
    StackService stackService;

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

    @PostMapping("/learners/{learnerId}/stacks/{stackId}")
    @PutMapping("/learners/{learnerId}/stacks/{stackId}")
    public Learner addStackToLearner(@PathVariable int learnerId, @PathVariable int stackId){
        Learner learner = this.learnerService.getLearnerById(learnerId);
        Stack stack = this.stackService.getStackById(stackId);

        this.learnerService.addStackToLearner(learner, stack);
        return learner;
    }

    @DeleteMapping("/learners/")
    public Boolean removeStackFromLearner(@PathVariable int learnerId, @PathVariable int stackId){
        Learner learner = this.learnerService.getLearnerById(learnerId);
        Stack stack = this.stackService.getStackById(stackId);

        Boolean result = this.learnerService.removeStackFromLearner(learner, stack);
        return result;
    }
}
