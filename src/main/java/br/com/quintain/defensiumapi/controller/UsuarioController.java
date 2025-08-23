package br.com.quintain.defensiumapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintain.defensiumapi.entity.PerfilEntity;
import br.com.quintain.defensiumapi.entity.UsuarioEntity;
import br.com.quintain.defensiumapi.service.UsuarioService;

@RestController
@RequestMapping("/defensium/usuario")
public class UsuarioController {

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public List<UsuarioEntity> findAll() {
		return this.usuarioService.findAll();
	}

	@GetMapping("/{code}")
	public List<PerfilEntity> recuperarPerfilUsuario(@PathVariable Long code) {
		return this.usuarioService.recuperarPerfilUsuario(code);
	}

}
