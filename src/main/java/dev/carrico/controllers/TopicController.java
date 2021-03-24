package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.Topic;
import dev.carrico.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Component
@RestController
@CrossOrigin
public class TopicController {
    @Autowired
    TopicService topicService;
    
    @PostMapping("/topics")
    @Authorized
    public Topic createTopic(@RequestBody Topic topic){
        this.topicService.createTopic(topic);
        return topic;
    }

    @GetMapping("/topics/{topicId}")
    public Topic getTopicById(@PathVariable int topicId){
        Topic topic = this.topicService.getTopicById(topicId);
        return topic;
    }

    @GetMapping("/topics")
    public Set<Topic> getTopics(@RequestParam(name = "topicName",defaultValue = "") String topicName){
        Set<Topic> topics;
        if (topicName.isEmpty()){
            topics = this.topicService.getAllTopics();
        }
        else {
            topics = new HashSet<>();
            topics.add(this.topicService.getTopicByName(topicName));
        }
        return topics;
    }

    @PutMapping("/topics/{topicId}")
    @Authorized
    public Topic updateTopic(@PathVariable int topicId, @RequestBody Topic topic){
        topic.setTopicId(topicId);
        this.topicService.updateTopic(topic);
        return topic;
    }

    @DeleteMapping("/topics/{topicId}")
    @Authorized
    public Boolean deleteTopicById(@PathVariable int topicId){
        Boolean result = this.topicService.deleteTopicById(topicId);
        return result;
    }
}
