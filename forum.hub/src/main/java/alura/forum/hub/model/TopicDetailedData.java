package alura.forum.hub.model;

import java.sql.Timestamp;

public record TopicDetailedData(
String titulo, String mensagem, Timestamp criacao,    
TopicState estado, String autor, String curso ) {

    public TopicDetailedData(Topic topic){
        this(topic.getTitle(), topic.getMessage(), topic.getCreated(), topic.getState(), topic.getAuthor(), topic.getCourse());
    }

}
