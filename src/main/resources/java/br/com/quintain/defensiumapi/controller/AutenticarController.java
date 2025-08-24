package br.com.quintain.defensiumapi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintain.defensiumapi.service.AutenticarService;

@RestController
@RequestMapping("/defensium/autenticar")
public class AutenticarController {

    private AutenticarService loginUsuarioService;

    public AutenticarController(AutenticarService loginUsuarioService) {
        this.loginUsuarioService = loginUsuarioService;
    }

    @PostMapping
    public String autenticar(Authentication authentication) {
        return loginUsuarioService.login(authentication);
    }

}
