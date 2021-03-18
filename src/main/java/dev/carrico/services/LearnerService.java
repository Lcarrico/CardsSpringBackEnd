package dev.carrico.services;

import dev.carrico.entities.Learner;
import dev.carrico.entities.Stack;

import java.util.Set;

public interface LearnerService {

    Learner createLearner(Learner learner);

    Learner getLearnerById(int learnerId);
    Set<Learner> getAllLearners();

    Learner updateLearner(Learner learner);

    boolean deleteLearnerById(int learnerId);

    Learner getByUsernameAndPassword(String username, String password);

    Learner addStackToLearner(Stack stack, Learner learner);

    Learner removeStackFromLearner(Stack stack, Learner learner);
}
