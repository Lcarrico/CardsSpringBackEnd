package dev.carrico.controllers;

import dev.carrico.entities.Topic;
import dev.carrico.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Component
@RestController
public class TopicController {
    @Autowired
    TopicService topicService;
    
    @PostMapping("/topics")
    @ResponseBody
    public Topic createTopic(@RequestBody Topic topic){
        this.topicService.createTopic(topic);
        return topic;
    }

    @GetMapping("/topics/{topicId}")
    @ResponseBody
    public Topic getTopicById(@PathVariable int topicId){
        Topic topic = this.topicService.getTopicById(topicId);
        return topic;
    }

    @GetMapping("/topics")
    @ResponseBody
    public Set<Topic> getAllTopics(@RequestParam(name = "topicName",defaultValue = "") String topicName){
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
    @ResponseBody
    public Topic updateTopic(@PathVariable int topicId, @RequestBody Topic topic){
        topic.setTopicId(topicId);
        this.topicService.updateTopic(topic);
        return topic;
    }

    @DeleteMapping("/topics/{topicId}")
    @ResponseBody
    public Boolean deleteBookById(@PathVariable int topicId){
        Boolean result = this.topicService.deleteTopicById(topicId);
        return result;
    }
}
