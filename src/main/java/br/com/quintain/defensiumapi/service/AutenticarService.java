package br.com.quintain.defensiumapi.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutenticarService {

    private JsonWebTokenService jsonWebTokenService;

    public AutenticarService(JsonWebTokenService jsonWebTokenService) {
        this.jsonWebTokenService = jsonWebTokenService;
    }

    public String login(Authentication authentication) {
        return jsonWebTokenService.gerarToken(authentication);
    }

}
