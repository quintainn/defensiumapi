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

import br.com.quintain.defensiumapi.utility.DataHoraUtility;

@SpringBootApplication
@RestController
@RequestMapping({"", "/", "/defensium"})
public class Application implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Value("${spring.application.name}")
	private String sistema;
	
	@Value("${server.port}")
	private String numeroPorta;
	
	@Value("${server.address}")
	private String endereco;
	
	@Value("${spring.application.version}")
	private String versao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@GetMapping
	public Map<String, String> informacao() {
		Map<String, String> informacao = new LinkedHashMap<>();
			informacao.put("Código", DataHoraUtility.obterNumeroInstancia());
			informacao.put("Sistema", sistema);
			informacao.put("Endereço", endereco);
			informacao.put("Porta", numeroPorta);
			informacao.put("Version", versao);
			informacao.put("Implantação", DataHoraUtility.obterDataHoraAtualFormatada());
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