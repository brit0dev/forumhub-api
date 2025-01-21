package alura.forum.hub.model;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationData(
@NotBlank    
String login, 

@NotBlank
String password) {

}
