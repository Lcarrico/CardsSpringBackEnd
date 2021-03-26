package dev.carrico.controllers;

import dev.carrico.aspects.Authorized;
import dev.carrico.entities.Topic;
import dev.carrico.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Component
@RestController
@CrossOrigin
public class TopicController {
    @Autowired
    TopicService topicService;
    
    @PostMapping("/topics")
    @Authorized
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic){
        this.topicService.createTopic(topic);
        return ResponseEntity.status(201).body(topic);
    }

    @GetMapping("/topics/{topicId}")
    public ResponseEntity<Topic> getTopicById(@PathVariable int topicId){
        Topic topic = this.topicService.getTopicById(topicId);
        return ResponseEntity.status(200).body(topic);
    }

    @GetMapping("/topics")
    public ResponseEntity<Set<Topic>> getTopics(@RequestParam(name = "topicName",defaultValue = "") String topicName){
        Set<Topic> topics;
        if (topicName.isEmpty()){
            topics = this.topicService.getAllTopics();
        }
        else {
            topics = new HashSet<>();
            topics.add(this.topicService.getTopicByName(topicName));
        }
        return ResponseEntity.status(200).body(topics);
    }

    @PutMapping("/topics/{topicId}")
    @Authorized
    public ResponseEntity<Topic> updateTopic(@PathVariable int topicId, @RequestBody Topic topic){
        topic.setTopicId(topicId);
        if (this.topicService.getTopicById(topicId) == null){
            throw new NoSuchElementException("Unable to update. This topic does not exist.");
        }
        this.topicService.updateTopic(topic);
        return ResponseEntity.status(200).body(topic);
    }

    @DeleteMapping("/topics/{topicId}")
    @Authorized
    public ResponseEntity<Boolean> deleteTopicById(@PathVariable int topicId){
        Boolean result = this.topicService.deleteTopicById(topicId);
        return ResponseEntity.status(200).body(result);
    }
}
