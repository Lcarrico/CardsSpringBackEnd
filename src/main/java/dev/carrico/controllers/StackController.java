package dev.carrico.controllers;

import dev.carrico.entities.Card;
import dev.carrico.entities.Stack;
import dev.carrico.entities.Tag;
import dev.carrico.services.CardService;
import dev.carrico.services.StackService;
import dev.carrico.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
public class StackController {
    @Autowired
    StackService stackService;

    @Autowired
    CardService cardService;

    @Autowired
    TagService tagService;

    @PostMapping("/stacks")
    public Stack createStack(@RequestBody Stack stack){
        this.stackService.createStack(stack);
        return stack;
    }

    @GetMapping("/stacks/{stackId}")
    public Stack getStackById(@PathVariable int stackId){
        Stack stack = this.stackService.getStackById(stackId);
        return stack;
    }

    @GetMapping("/stacks")
    public Set<Stack> getAllStacks(){
        Set<Stack> stacks = this.stackService.getAllStacks();
        return stacks;
    }

    @PutMapping("/stacks/{stackId}")
    public Stack updateStack(@PathVariable int stackId, @RequestBody Stack stack){
        stack.setStackId(stackId);
        this.stackService.updateStack(stack);
        return stack;
    }

    @DeleteMapping("/stacks/{stackId}")
    public Boolean deleteBookById(@PathVariable int stackId){
        Boolean result = this.stackService.deleteStackById(stackId);
        return result;
    }

    @PutMapping("/stacks/{stackId}/cards/{cardId}")
    public Stack addCardToStack(@PathVariable int stackId, @PathVariable int cardId){
        Stack stack = this.stackService.getStackById(stackId);
        Card card = this.cardService.getCardById(cardId);
        this.stackService.addCardToStack(card, stack);
        return stack;
    }

    @PutMapping("/stacks/{stackId}/tags/{tagId}")
    public Stack addTagToStack(@PathVariable int stackId, @PathVariable int tagId){
        Stack stack = this.stackService.getStackById(stackId);
        Tag tag = this.tagService.getTagById(tagId);
        this.stackService.addTagToStack(tag, stack);
        return stack;
    }

    // TODO remove card from stack

    // TODO remove tag from stack
}
