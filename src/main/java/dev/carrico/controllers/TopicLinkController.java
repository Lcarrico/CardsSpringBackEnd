package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.TopicLink;
import dev.carrico.services.StackService;
import dev.carrico.services.TopicLinkService;
import dev.carrico.services.TopicService;
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
public class TopicLinkController {
    @Autowired
    TopicLinkService topicLinkService;

    @Autowired
    TopicService topicService;

    @Autowired
    StackService stackService;

    private void checkValidity(TopicLink topicLink){
        Set<TopicLink> topicLinks = this.topicLinkService.getTopicLinksByStackId(topicLink.getStackId());
        for (TopicLink tl: topicLinks){
            if (tl.getTopicId() == topicLink.getTopicId()){
                throw new DuplicateKeyException("TopicLink already exists!");
            }
        }
        if (this.topicService.getTopicById(topicLink.getTopicId()) == null
                || this.stackService.getStackById(topicLink.getStackId()) == null){
            throw new NoSuchElementException("Topic or Stack does not exist. Unable to create link.");
        }
    }
    @PostMapping("/topicLinks")
    @Authorized
    public ResponseEntity<TopicLink> createTopicLink(@RequestBody TopicLink topicLink){
        this.checkValidity(topicLink);
        this.topicLinkService.createTopicLink(topicLink);
        return ResponseEntity.status(201).body(topicLink);
    }

    @GetMapping("/topicLinks/{topicLinkId}")
    public ResponseEntity<TopicLink> getTopicLinkById(@PathVariable int topicLinkId){
        TopicLink topicLink = this.topicLinkService.getTopicLinkById(topicLinkId);
        return ResponseEntity.status(200).body(topicLink);
    }

    @GetMapping("/topicLinks")
    public ResponseEntity<Set<TopicLink>> getTopicLinks(@RequestParam(name = "topicId", defaultValue = "") String topicId,
                                       @RequestParam(name = "stackId", defaultValue = "") String stackId){
        Set<TopicLink> topicLinks = null;
        if (topicId.isEmpty() && stackId.isEmpty()){
            topicLinks = this.topicLinkService.getAllTopicLinks();
        }
        else if (!topicId.isEmpty()){
            topicLinks = this.topicLinkService.getTopicLinksByTopicId(Integer.parseInt(topicId));
        }
        else if (!stackId.isEmpty()){
            topicLinks = this.topicLinkService.getTopicLinksByStackId(Integer.parseInt(stackId));
        }
        return ResponseEntity.status(200).body(topicLinks);
    }

    @PutMapping("/topicLinks/{topicLinkId}")
    @Authorized
    public ResponseEntity<TopicLink> updateTopicLink(@PathVariable int topicLinkId, @RequestBody TopicLink topicLink){
        topicLink.setTopicLinkId(topicLinkId);
        this.checkValidity(topicLink);
        if (this.topicLinkService.getTopicLinkById(topicLinkId) == null){
            throw new NoSuchElementException("Unable to update. This topiclink does not exist.");
        }
        this.topicLinkService.updateTopicLink(topicLink);
        return ResponseEntity.status(200).body(topicLink);
    }

    @DeleteMapping("/topicLinks/{topicLinkId}")
    @Authorized
    public ResponseEntity<Boolean> deleteTopicLinkById(@PathVariable int topicLinkId){
        Boolean result = this.topicLinkService.deleteTopicLinkById(topicLinkId);
        return ResponseEntity.status(200).body(result);
    }

}
