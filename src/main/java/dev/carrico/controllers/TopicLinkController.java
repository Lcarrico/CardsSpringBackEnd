package dev.carrico.controllers;

import dev.carrico.entities.TopicLink;
import dev.carrico.services.TopicLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Component
@RestController
public class TopicLinkController {
    @Autowired
    TopicLinkService topicLinkService;

    @PostMapping("/topicLinks")
    @ResponseBody
    public TopicLink createTopicLink(@RequestBody TopicLink topicLink){
        this.topicLinkService.createTopicLink(topicLink);
        return topicLink;
    }

    @GetMapping("/topicLinks/{topicLinkId}")
    @ResponseBody
    public TopicLink getTopicLinkById(@PathVariable int topicLinkId){
        TopicLink topicLink = this.topicLinkService.getTopicLinkById(topicLinkId);
        return topicLink;
    }

    @GetMapping("/topicLinks")
    @ResponseBody
    public Set<TopicLink> getTopicLinks(@RequestParam(name = "topicId", defaultValue = "") String topicId,
                                       @RequestParam(name = "stackId", defaultValue = "") String stackId){
        Set<TopicLink> topicLinks;
        if (topicId.isEmpty() && stackId.isEmpty()){
            topicLinks = this.topicLinkService.getAllTopicLinks();
        }
        else if (!topicId.isEmpty()){
            topicLinks = this.topicLinkService.getTopicLinksByTopicId(Integer.parseInt(topicId));
        }
        else if (!stackId.isEmpty()){
            topicLinks = this.topicLinkService.getTopicLinksByStackId(Integer.parseInt(stackId));
        }
        else {
            topicLinks = null;
        }
        return topicLinks;
    }

    @PutMapping("/topicLinks/{topicLinkId}")
    @ResponseBody
    public TopicLink updateTopicLink(@PathVariable int topicLinkId, @RequestBody TopicLink topicLink){
        topicLink.setTopicLinkId(topicLinkId);
        this.topicLinkService.updateTopicLink(topicLink);
        return topicLink;
    }

    @DeleteMapping("/topicLinks/{topicLinkId}")
    @ResponseBody
    public Boolean deleteTopicLinkById(@PathVariable int topicLinkId){
        Boolean result = this.topicLinkService.deleteTopicLinkById(topicLinkId);
        return result;
    }

}
