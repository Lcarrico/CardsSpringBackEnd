package dev.carrico.services;

import dev.carrico.entities.Stack;

import java.util.Set;

public interface StackService {
    Stack createStack(Stack stack);

    Stack getStackById(int stackId);
    Set<Stack> getAllStacks();

    Stack updateStack(Stack stack);

    boolean deleteStackById(int stackId);

}
