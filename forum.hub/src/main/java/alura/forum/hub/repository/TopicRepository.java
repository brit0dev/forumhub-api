package alura.forum.hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import alura.forum.hub.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
