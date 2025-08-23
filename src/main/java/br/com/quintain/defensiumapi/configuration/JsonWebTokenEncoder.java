package br.com.quintain.defensiumapi.configuration;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class JsonWebTokenEncoder {

    @Value("${seguranca.jwt.chave.publica}")
    private RSAPublicKey rsaPublicKey;

    @Value("${seguranca.jwt.chave.privada}")
    private RSAPrivateKey RSAPrivateKey;

    @Bean
    JwtEncoder jwtEncoder() {
        RSAKey jwk = new RSAKey.Builder(rsaPublicKey).privateKey(RSAPrivateKey).build();
        ImmutableJWKSet<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }

}
