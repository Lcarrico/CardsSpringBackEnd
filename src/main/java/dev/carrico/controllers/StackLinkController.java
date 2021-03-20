package dev.carrico.controllers;

import dev.carrico.entities.StackLink;
import dev.carrico.services.StackLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
public class StackLinkController {
    @Autowired
    StackLinkService stackLinkService;

    @PostMapping("/stackLinks")
    public StackLink createStackLink(@RequestBody StackLink stackLink){
        this.stackLinkService.createStackLink(stackLink);
        return stackLink;
    }

    @GetMapping("/stackLinks")
    public Set<StackLink> getStackLinks(@RequestParam(name = "learnerId", defaultValue = "") String learnerId,
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
        return stackLinks;
    }

    @GetMapping("/stackLinks/{stackLinkId}")
    public StackLink getStackLinkById(@PathVariable int stackLinkId){
        StackLink stackLink = this.stackLinkService.getStackLinkById(stackLinkId);
        return stackLink;
    }

    @PutMapping("/stackLinks/{stackLinkId}")
    public StackLink updateStackLink(@PathVariable int stackLinkId, @RequestBody StackLink stackLink){
        stackLink.setStackLinkId(stackLinkId);
        this.stackLinkService.updateStackLink(stackLink);
        return stackLink;
    }

    @DeleteMapping("/stackLinks/{stackLinkId}")
    public Boolean deleteStackLinkById(@PathVariable int stackLinkId){
        Boolean result = this.stackLinkService.deleteStackLinkById(stackLinkId);
        return result;
    }
}
