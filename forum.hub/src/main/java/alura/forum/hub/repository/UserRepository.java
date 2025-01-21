package alura.forum.hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import alura.forum.hub.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);



}
