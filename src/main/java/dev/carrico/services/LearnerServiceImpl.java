package dev.carrico.services;

import dev.carrico.entities.Card;
import dev.carrico.entities.Learner;
import dev.carrico.entities.Stack;
import dev.carrico.entities.Tag;
import dev.carrico.repos.LearnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
@Service
public class LearnerServiceImpl implements LearnerService{

    @Autowired
    LearnerRepo learnerRepo;


    @Override
    public Learner createLearner(Learner learner) {
        learnerRepo.save(learner);
        return learner;
    }

    @Override
    public Learner getLearnerById(int learnerId) {
        Learner learner = learnerRepo.findById(learnerId).get();
        return learner;
    }

    @Override
    public Set<Learner> getAllLearners() {
        Set<Learner> learners = new HashSet<>();
        this.learnerRepo.findAll().forEach(learners::add);
        return learners;
    }

    @Override
    public Learner updateLearner(Learner learner) {
        this.learnerRepo.save(learner);
        return learner;
    }

    @Override
    public boolean deleteLearnerById(int learnerId) {
        this.learnerRepo.deleteById(learnerId);
        return true;
    }

    @Override
    public Learner getByUsernameAndPassword(String username, String password) {
        Learner learner = this.learnerRepo.findByUsernameAndPassword(username, password);
        return learner;
    }

    @Override
    public Learner addStackToLearner(Learner learner, Stack stack) {
        learner.getStacks().add(stack);
        this.learnerRepo.save(learner);
        return learner;
    }

    @Override
    public Learner removeStackFromLearner(Learner learner, Stack stack) {
        for (Stack temp : learner.getStacks()){
            if (temp.getStackId() == stack.getStackId()){
                learner.getStacks().remove(temp);
                break;
            }
        }
        this.learnerRepo.save(learner);
        return learner;
    }


}
