package alura.forum.hub.model;

import jakarta.validation.constraints.NotBlank;

public record TopicCreationData( 
    @NotBlank(message="O título é obrigatório.")
    String titulo,

    @NotBlank(message="A mensagem é obrigatória.") 
    String mensagem,

    @NotBlank(message="O autor é obrigatório.")
    String autor,

    @NotBlank(message="O autor é obrigatório.") 
    String curso
){

    public TopicCreationData(Topic topic){
        this(topic.getTitle(), topic.getMessage(), topic.getAuthor(), topic.getCourse());
    }
}
