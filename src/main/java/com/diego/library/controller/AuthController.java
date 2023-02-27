package com.diego.library.controller;

import com.diego.library.domain.usuario.LoginData;
import com.diego.library.domain.usuario.User;
import com.diego.library.infra.security.TokenData;
import com.diego.library.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginData login) {
        System.out.println(login.login());
        System.out.println(login.password());
        var authenticationToken = new UsernamePasswordAuthenticationToken(login.login(), login.password());
        var authentication = this.manager.authenticate(authenticationToken);
        User user = (User) authentication.getPrincipal();
        String token = this.tokenService.generateToken(user);
        return ResponseEntity.ok(new TokenData(token));
    }
}
