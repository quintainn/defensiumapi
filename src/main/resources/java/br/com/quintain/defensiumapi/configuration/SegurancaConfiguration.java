package br.com.quintain.defensiumapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SegurancaConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(authorize -> authorize
					.requestMatchers("/autenticar").permitAll()
					.requestMatchers(HttpMethod.POST, "/defensium/usuario").permitAll()
				.anyRequest().authenticated())
			.formLogin(form -> form.disable())
			.httpBasic(httpBasic -> Customizer.withDefaults())
			.oauth2ResourceServer(configuration -> configuration.jwt(Customizer.withDefaults()))
			.build();
	}

}
