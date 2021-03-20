package dev.carrico.services;

import dev.carrico.entities.Stack;
import dev.carrico.repos.StackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
@Service
public class StackServiceImpl implements StackService{

    @Autowired
    StackRepo stackRepo;

    @Override
    public Stack createStack(Stack stack) {
        this.stackRepo.save(stack);
        return stack;
    }

    @Override
    public Stack getStackById(int stackId) {
        Stack stack = this.stackRepo.findById(stackId).get();
        return stack;
    }

    @Override
    public Set<Stack> getAllStacks() {
        Set<Stack> stacks = new HashSet<>();
        this.stackRepo.findAll().forEach(stacks::add);
        return stacks;
    }

    @Override
    public Stack updateStack(Stack stack) {
        this.stackRepo.save(stack);
        return stack;
    }

    @Override
    public boolean deleteStackById(int stackId) {
        this.stackRepo.deleteById(stackId);
        return true;
    }
}
