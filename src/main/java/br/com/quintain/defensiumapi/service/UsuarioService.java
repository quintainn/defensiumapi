package br.com.quintain.defensiumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.quintain.defensiumapi.entity.PerfilEntity;
import br.com.quintain.defensiumapi.entity.UsuarioEntity;
import br.com.quintain.defensiumapi.entity.UsuarioPerfilEntity;
import br.com.quintain.defensiumapi.repository.UsuarioPerfilRepository;
import br.com.quintain.defensiumapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	private final UsuarioPerfilRepository usuarioPerfilRepository;

	public UsuarioService(UsuarioRepository usuarioRepository, UsuarioPerfilRepository usuarioPerfilRepository) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioPerfilRepository = usuarioPerfilRepository;
	}

	public List<UsuarioEntity> findAll() {
		return usuarioRepository.findAll();
	}

	public List<PerfilEntity> recuperarPerfilUsuario(Long code) {
		return this.usuarioPerfilRepository
			.findPerfilEntityByUsuarioEntityCode(code)
			.stream()
			.map(UsuarioPerfilEntity::getPerfilEntity)
			.toList();
	}

}
