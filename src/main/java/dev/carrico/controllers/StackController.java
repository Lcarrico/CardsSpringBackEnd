package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.Stack;
import dev.carrico.services.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
@CrossOrigin
public class StackController {
    @Autowired
    StackService stackService;

    @PostMapping("/stacks")
    @Authorized
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
    @Authorized
    public Stack updateStack(@PathVariable int stackId, @RequestBody Stack stack){
        stack.setStackId(stackId);
        this.stackService.updateStack(stack);
        return stack;
    }

    @DeleteMapping("/stacks/{stackId}")
    @Authorized
    public Boolean deleteStack(@PathVariable int stackId){
        Boolean result = this.stackService.deleteStackById(stackId);
        return result;
    }
}
