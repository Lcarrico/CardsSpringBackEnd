package dev.carrico.services;

import dev.carrico.entities.Card;
import dev.carrico.entities.Stack;
import dev.carrico.entities.Tag;
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

    @Override
    public Stack addTagToStack(Tag tag, Stack stack) {
        stack.getTags().add(tag);
        this.stackRepo.save(stack);
        return stack;
    }

    @Override
    public Stack addCardToStack(Card card, Stack stack) {
        stack.getCards().add(card);
        this.stackRepo.save(stack);
        return stack;
    }

    @Override
    public Stack removeTagFromStack(Tag tag, Stack stack) {
        for (Tag temp : stack.getTags()){
            if (temp.getTagId() == tag.getTagId()){
                stack.getTags().remove(temp);
            }
        }
        this.stackRepo.save(stack);
        return stack;
    }

    @Override
    public Stack removeCardFromStack(Card card, Stack stack) {
        for (Card temp : stack.getCards()){
            if(temp.getCardId() == card.getCardId()){
                stack.getCards().remove(temp);
            }
        }
        this.stackRepo.save(stack);
        return stack;
    }


}
