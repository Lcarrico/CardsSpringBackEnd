package dev.carrico.services;

import dev.carrico.entities.Card;
import dev.carrico.entities.Stack;
import dev.carrico.entities.Tag;

import java.util.Set;

public interface StackService {
    Stack createStack(Stack stack);

    Stack getStackById(int stackId);
    Set<Stack> getAllStacks();

    Stack updateStack(Stack stack);

    boolean deleteStackById(int stackId);

    Stack addTagToStack(Stack stack, Tag tag);

    Stack addCardToStack(Stack stack, Card card);

    Stack removeTagFromStack(Stack stack, Tag tag);

    Stack removeCardFromStack(Stack stack, Card card);
}
