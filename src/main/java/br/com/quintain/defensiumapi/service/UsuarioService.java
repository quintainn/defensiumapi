package br.com.quintain.defensiumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.quintain.defensiumapi.entity.UsuarioEntity;
import br.com.quintain.defensiumapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<UsuarioEntity> findAll() {
		return usuarioRepository.findAll();
	}

}
