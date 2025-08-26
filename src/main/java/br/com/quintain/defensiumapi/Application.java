package br.com.quintain.defensiumapi;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
@RestController
@RequestMapping({"", "/", "/defensium"})
public class Application implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Value("${server.port}")
	private String numeroPorta;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping
	public Map<String, String> informacao() {
		Map<String, String> informacao = new LinkedHashMap<>();
			informacao.put("Código", "DEFENSIUM20250820190211API");
			informacao.put("Sistema", "Defensium Service");
			informacao.put("Endereço", "192.168.1.3");
			informacao.put("Porta", numeroPorta);
			informacao.put("Version", "v1.0.0");
			informacao.put("Implantação", "20/08/2024 às 19:55:02");
			informacao.put("Ambiente", "Desenvolvimento");
			informacao.put("Servidor", "Linux");
		return informacao;
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		log.warn(objectMapper.writeValueAsString(this.informacao()));
	}

}