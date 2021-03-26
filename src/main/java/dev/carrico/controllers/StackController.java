package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.Stack;
import dev.carrico.services.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Set;

@Component
@RestController
@CrossOrigin
public class StackController {
    @Autowired
    StackService stackService;

    @PostMapping("/stacks")
    @Authorized
    public ResponseEntity<Stack> createStack(@RequestBody Stack stack){
        this.stackService.createStack(stack);
        return ResponseEntity.status(200).body(stack);
    }

    @GetMapping("/stacks/{stackId}")
    public ResponseEntity<Stack> getStackById(@PathVariable int stackId){
        Stack stack = this.stackService.getStackById(stackId);
        return ResponseEntity.status(200).body(stack);
    }

    @GetMapping("/stacks")
    public ResponseEntity<Set<Stack>> getAllStacks(){
        Set<Stack> stacks = this.stackService.getAllStacks();
        return ResponseEntity.status(200).body(stacks);
    }

    @PutMapping("/stacks/{stackId}")
    @Authorized
    public ResponseEntity<Stack> updateStack(@PathVariable int stackId, @RequestBody Stack stack){
        stack.setStackId(stackId);
        if (this.stackService.getStackById(stackId) == null){
            throw new NoSuchElementException("Unable to update. This stack does not exist.");
        }
        this.stackService.updateStack(stack);
        return ResponseEntity.status(200).body(stack);
    }

    @DeleteMapping("/stacks/{stackId}")
    @Authorized
    public ResponseEntity<Boolean> deleteStack(@PathVariable int stackId){
        Boolean result = this.stackService.deleteStackById(stackId);
        return ResponseEntity.status(200).body(result);
    }
}
