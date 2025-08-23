package br.com.quintain.defensiumapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintain.defensiumapi.entity.PerfilEntity;
import br.com.quintain.defensiumapi.entity.UsuarioEntity;
import br.com.quintain.defensiumapi.service.UsuarioService;
import br.com.quintain.defensiumapi.transfer.UsuarioTransfer;

@RestController
@RequestMapping("/defensium/usuario")
public class UsuarioController {

	private final UsuarioService usuarioService;

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

	@PostMapping
	public ResponseEntity<UsuarioTransfer> createOne(@RequestBody UsuarioTransfer usuarioTransfer) {
		return ResponseEntity.ok().body(this.usuarioService.createOne(usuarioTransfer));
	}

}
