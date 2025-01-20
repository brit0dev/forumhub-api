package alura.forum.hub.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="topics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String message;

    @CreationTimestamp
    private Timestamp created;
    
    private boolean state;

    private String author;

    private String course;

    public Topic(TopicCreationData data) {
        this.title = data.titulo();
        this.message = data.mensagem();
        this.state = true;
        this.author = data.autor();
        this.course = data.curso();
    }

    public void update(TopicCreationData data) {
        if (data.mensagem() != null) this.message = data.mensagem();
        if (data.titulo() != null) this.title = data.titulo();
        if (data.autor() != null) this.author = data.autor();
        if (data.curso() != null) this.course = data.curso();
    }



    public boolean getState(){
        return this.state;
    }

    public boolean setState(boolean state){
        return this.state = state;
    }
}
