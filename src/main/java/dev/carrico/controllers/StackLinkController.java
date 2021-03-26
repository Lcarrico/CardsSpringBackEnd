package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.StackLink;
import dev.carrico.services.LearnerService;
import dev.carrico.services.StackLinkService;
import dev.carrico.services.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Set;

@Component
@RestController
@CrossOrigin
public class StackLinkController {
    @Autowired
    StackLinkService stackLinkService;

    @Autowired
    LearnerService learnerService;

    @Autowired
    StackService stackService;

    private void checkValidity(StackLink stackLink){
        Set<StackLink> stackLinks = this.stackLinkService.getStackLinksByLearnerId(stackLink.getLearnerId());
        for (StackLink sl: stackLinks){
            if (sl.getStackId() == stackLink.getStackId() && sl.getRelationship() == stackLink.getRelationship()){
                throw new DuplicateKeyException("StackLink already exists!");
            }
        }
        if (this.learnerService.getLearnerById(stackLink.getLearnerId()) == null
                || this.stackService.getStackById(stackLink.getStackId()) == null){
            throw new NoSuchElementException("Learner or stack does not exist. Unable to create link.");
        }
    }

    @PostMapping("/stackLinks")
    @Authorized
    public ResponseEntity<StackLink> createStackLink(@RequestBody StackLink stackLink){
        this.checkValidity(stackLink);
        stackLink = this.stackLinkService.createStackLink(stackLink);
        return ResponseEntity.status(200).body(stackLink);
    }

    @GetMapping("/stackLinks")
    public ResponseEntity<Set<StackLink>> getStackLinks(@RequestParam(name = "learnerId", defaultValue = "") String learnerId,
                                        @RequestParam(name = "relationship", defaultValue = "") String relationship){
        Set<StackLink> stackLinks = null;
        if (learnerId.isEmpty() && relationship.isEmpty()){
            stackLinks = this.stackLinkService.getAllStackLinks();
        }
        else if (!learnerId.isEmpty()){
            stackLinks = this.stackLinkService.getStackLinksByLearnerId(Integer.parseInt(learnerId));
        }
        else if (!relationship.isEmpty()){
            stackLinks = this.stackLinkService.getStackLinksByRelationship(relationship);
        }
        return ResponseEntity.status(200).body(stackLinks);
    }

    @GetMapping("/stackLinks/{stackLinkId}")
    public ResponseEntity<StackLink> getStackLinkById(@PathVariable int stackLinkId){
        StackLink stackLink = this.stackLinkService.getStackLinkById(stackLinkId);
        return ResponseEntity.status(200).body(stackLink);
    }

    @PutMapping("/stackLinks/{stackLinkId}")
    @Authorized
    public ResponseEntity<StackLink> updateStackLink(@PathVariable int stackLinkId, @RequestBody StackLink stackLink){
        stackLink.setStackLinkId(stackLinkId);
        this.checkValidity(stackLink);
        if (this.stackLinkService.getStackLinkById(stackLinkId) == null){
            throw new NoSuchElementException("Unable to update. This stacklink does not exist.");
        }
        this.stackLinkService.updateStackLink(stackLink);
        return ResponseEntity.status(200).body(stackLink);
    }

    @DeleteMapping("/stackLinks/{stackLinkId}")
    @Authorized
    public ResponseEntity<Boolean> deleteStackLinkById(@PathVariable int stackLinkId){
        Boolean result = this.stackLinkService.deleteStackLinkById(stackLinkId);
        return ResponseEntity.status(200).body(result);
    }
}
