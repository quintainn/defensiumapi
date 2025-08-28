package br.com.quintain.defensiumapi.service;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import br.com.quintain.defensiumapi.entity.UsuarioEntity;

@Service
public class JsonWebTokenService {

    private JwtEncoder jwtEncoder;

    public JsonWebTokenService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String gerarToken(Authentication authentication) {
        Instant agora = Instant.now();
        long tempoExpiracao = 3600L;
        String scopo = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        UsuarioEntity usuarioEntity = (UsuarioEntity) authentication.getPrincipal();
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet
            .builder()
            .issuer("defensium-service")
            .issuedAt(agora)
            .expiresAt(agora.plusSeconds(tempoExpiracao))
            .subject(scopo)
            .claim("scope", scopo)
            .claim("sistemaID", usuarioEntity.getSistemaEntity().getCode())
            .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
    }

}
