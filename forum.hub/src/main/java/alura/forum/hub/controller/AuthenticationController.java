package alura.forum.hub.controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alura.forum.hub.model.AuthenticationData;
import alura.forum.hub.model.TokenJWTData;
import alura.forum.hub.model.User;
import alura.forum.hub.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthenticationData data){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        System.out.println(data);
        System.out.println("Sem erro " + token);
        Authentication authentication = manager.authenticate(token);
        TokenJWTData tokenJWT = new TokenJWTData(tokenService.generateToken((User) authentication.getPrincipal()));

        return ResponseEntity.ok(tokenJWT);
    }   
}
