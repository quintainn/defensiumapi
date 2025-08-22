package br.com.quintain.defensiumapi.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.quintain.defensiumapi.entity.PerfilEntity;
import br.com.quintain.defensiumapi.entity.UsuarioEntity;
import br.com.quintain.defensiumapi.entity.UsuarioPerfilEntity;
import br.com.quintain.defensiumapi.repository.UsuarioPerfilRepository;
import br.com.quintain.defensiumapi.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

	private UsuarioRepository usuarioRepository;

	private final UsuarioPerfilRepository usuarioPerfilRepository;

	private final PasswordEncoder passwordEncoder;

	public UsuarioService(UsuarioRepository usuarioRepository, UsuarioPerfilRepository usuarioPerfilRepository,
			PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioPerfilRepository = usuarioPerfilRepository;
		this.passwordEncoder = passwordEncoder;
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
	}

}
