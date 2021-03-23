package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.TopicLink;
import dev.carrico.services.TopicLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
@CrossOrigin
public class TopicLinkController {
    @Autowired
    TopicLinkService topicLinkService;

    @PostMapping("/topicLinks")
    @Authorized
    public TopicLink createTopicLink(@RequestBody TopicLink topicLink){
        this.topicLinkService.createTopicLink(topicLink);
        return topicLink;
    }

    @GetMapping("/topicLinks/{topicLinkId}")
    @Authorized
    public TopicLink getTopicLinkById(@PathVariable int topicLinkId){
        TopicLink topicLink = this.topicLinkService.getTopicLinkById(topicLinkId);
        return topicLink;
    }

    @GetMapping("/topicLinks")
    @Authorized
    public Set<TopicLink> getTopicLinks(@RequestParam(name = "topicId", defaultValue = "") String topicId,
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
        return topicLinks;
    }

    @PutMapping("/topicLinks/{topicLinkId}")
    @Authorized
    public TopicLink updateTopicLink(@PathVariable int topicLinkId, @RequestBody TopicLink topicLink){
        topicLink.setTopicLinkId(topicLinkId);
        this.topicLinkService.updateTopicLink(topicLink);
        return topicLink;
    }

    @DeleteMapping("/topicLinks/{topicLinkId}")
    @Authorized
    public Boolean deleteTopicLinkById(@PathVariable int topicLinkId){
        Boolean result = this.topicLinkService.deleteTopicLinkById(topicLinkId);
        return result;
    }

}
