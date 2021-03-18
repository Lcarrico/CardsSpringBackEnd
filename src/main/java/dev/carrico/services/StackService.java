package dev.carrico.services;

import dev.carrico.entities.Card;
import dev.carrico.entities.Stack;
import dev.carrico.entities.Tag;
import dev.carrico.entities.Topic;

import java.util.Set;

public interface StackService {
    Stack createStack(Stack stack);

    Stack getStackById(int stackId);
    Set<Stack> getAllStacks();

    Stack updateStack(Stack stack);

    boolean deleteStackById(int stackId);

    Stack addTopicToStack(Stack stack, Topic topic);

    Stack addCardToStack(Stack stack, Card card);

    boolean removeTopicFromStack(Stack stack, Topic topic);

    boolean removeCardFromStack(Stack stack, Card card);
}
