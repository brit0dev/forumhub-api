package alura.forum.hub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alura.forum.hub.model.Topic;
import alura.forum.hub.model.TopicCreationData;
import alura.forum.hub.model.TopicDetailedData;
import alura.forum.hub.repository.TopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid TopicCreationData data){
        Topic topic = new Topic(data);

        topicRepository.save(topic);
    }

    @GetMapping
    public List<TopicDetailedData> list(){
        return topicRepository.findAll().stream().map(t -> new TopicDetailedData(t)).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailedData> show(@PathVariable Long id){
        Optional<Topic> topic = topicRepository.findById(id);

        if(topic.isPresent()){
            return ResponseEntity.ok(new TopicDetailedData(topic.get()));
        }
        
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicCreationData> update(@PathVariable Long id, @RequestBody @Valid TopicCreationData topic){
        Optional<Topic> topicSearched = topicRepository.findById(id);

        if(topicSearched.isPresent()){
            topicSearched.get().update(topic);
            return ResponseEntity.ok(new TopicCreationData(topicSearched.get()));
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Topic> topicSearched = topicRepository.findById(id);

        if(topicSearched.isPresent()){
            topicRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.notFound().build();
    }
}


