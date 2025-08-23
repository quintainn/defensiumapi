package br.com.quintain.defensiumapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintain.defensiumapi.entity.PerfilEntity;
import br.com.quintain.defensiumapi.service.PerfilService;

@RestController
@RequestMapping("/defensium/perfil")
public class PerfilController {

	private PerfilService perfilService;

	public PerfilController(PerfilService perfilService) {
		this.perfilService = perfilService;
	}

	@GetMapping
	public List<PerfilEntity> findAll() {
		return perfilService.findAll();
	}

}
