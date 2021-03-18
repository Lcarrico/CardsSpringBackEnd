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

    Stack addTagToStack(Tag tag, Stack stack);

    Stack addCardToStack(Card card, Stack stack);

    Stack removeTagFromStack(Tag tag, Stack stack);

    Stack removeCardFromStack(Card card, Stack stack);
}
