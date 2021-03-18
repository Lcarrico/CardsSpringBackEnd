package dev.carrico.controllers;

import dev.carrico.entities.Card;
import dev.carrico.entities.Stack;
import dev.carrico.entities.Tag;
import dev.carrico.entities.Topic;
import dev.carrico.services.CardService;
import dev.carrico.services.StackService;
import dev.carrico.services.TagService;
import dev.carrico.services.TopicService;
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
    TopicService topicService;

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

    @PostMapping("/stacks/{stackId}/cards/{cardId}")
    @PutMapping("/stacks/{stackId}/cards/{cardId}")
    public Stack addCardToStack(@PathVariable int stackId, @PathVariable int cardId){
        Stack stack = this.stackService.getStackById(stackId);
        Card card = this.cardService.getCardById(cardId);
        this.stackService.addCardToStack(stack, card);
        return stack;
    }

    @PostMapping("/stacks/{stackId}/tags/{tagId}")
    @PutMapping("/stacks/{stackId}/tags/{tagId}")
    public Stack addTopicToStack(@PathVariable int stackId, @PathVariable int topicId){
        Stack stack = this.stackService.getStackById(stackId);
        Topic topic = this.topicService.getTopicById(topicId);
        this.stackService.addTopicToStack(stack, topic);
        return stack;
    }

    @DeleteMapping("/stacks/{stackId}/tags/{tagId}")
    public Boolean removeTagFromStack(@PathVariable int stackId, @PathVariable int topicId){
        Stack stack = this.stackService.getStackById(stackId);
        Topic topic = this.topicService.getTopicById(topicId);

        Boolean result = this.stackService.removeTopicFromStack(stack, topic);
        return result;
    }

    @DeleteMapping("/stacks/{stackId}/cards/{cardsId}")
    public Boolean removeCardFromStack(@PathVariable int stackId, @PathVariable int cardId){
        Stack stack = this.stackService.getStackById(stackId);
        Card card = this.cardService.getCardById(cardId);

        Boolean result = this.stackService.removeCardFromStack(stack, card);
        return result;
    }
}
