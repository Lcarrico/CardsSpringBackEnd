package dev.carrico.services;

import dev.carrico.entities.Learner;
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
        learner.setLearnerId(0);
        learnerRepo.save(learner);
        return learner;
    }

    @Override
    public Learner getLearnerById(int learnerId) {
        Learner learner = learnerRepo.findById(learnerId).get();
        return learner;
    }

    @Override
    public Learner getLearnerByUsername(String username){
        Learner learner = learnerRepo.findByUsername(username);
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
}
