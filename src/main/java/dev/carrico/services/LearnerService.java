package dev.carrico.services;

import dev.carrico.entities.Learner;

import java.util.Set;

public interface LearnerService {

    Learner createLearner(Learner learner);

    Learner getLearnerById(int learnerId);
    Learner getLearnerByUsername(String username);
    Set<Learner> getAllLearners();

    Learner updateLearner(Learner learner);

    boolean deleteLearnerById(int learnerId);
}
