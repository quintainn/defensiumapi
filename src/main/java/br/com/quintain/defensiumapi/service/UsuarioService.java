package br.com.quintain.defensiumapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.quintain.defensiumapi.entity.PerfilEntity;
import br.com.quintain.defensiumapi.entity.UsuarioEntity;
import br.com.quintain.defensiumapi.entity.UsuarioPerfilEntity;
import br.com.quintain.defensiumapi.mapper.UsuarioMapper;
import br.com.quintain.defensiumapi.repository.PerfilRepository;
import br.com.quintain.defensiumapi.repository.UsuarioPerfilRepository;
import br.com.quintain.defensiumapi.repository.UsuarioRepository;
import br.com.quintain.defensiumapi.transfer.UsuarioRequestTransfer;
import br.com.quintain.defensiumapi.transfer.UsuarioResponseTransfer;

@Service
public class UsuarioService implements UserDetailsService {

	private UsuarioRepository usuarioRepository;

	private final UsuarioPerfilRepository usuarioPerfilRepository;

	private final PasswordEncoder passwordEncoder;

	private final PerfilRepository perfilRepository;

	private static final Long PERFIL_USUARIO_CODE = 2L;

	public UsuarioService(UsuarioRepository usuarioRepository, UsuarioPerfilRepository usuarioPerfilRepository, PasswordEncoder passwordEncoder, PerfilRepository perfilRepository) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioPerfilRepository = usuarioPerfilRepository;
		this.passwordEncoder = passwordEncoder;
		this.perfilRepository = perfilRepository;
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
		Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findByUsuario(username);
		if (usuarioEntityOptional.isEmpty()) {
			throw new UsernameNotFoundException("Esse usuário não está registrado no sistema!");
		}
		return usuarioEntityOptional.get();
	}

	public UsuarioResponseTransfer createOne(UsuarioRequestTransfer usuarioTransfer) {
		UsuarioMapper usuarioMapper = new UsuarioMapper(passwordEncoder);
		UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuarioTransfer);
		UsuarioEntity usuarioEntityDatabase = this.usuarioRepository.save(usuarioEntity);
		this.cadastrarPerfilUsuario(usuarioEntity);
		return UsuarioMapper.toTransferResponse(usuarioEntityDatabase);
	}

	private void cadastrarPerfilUsuario(UsuarioEntity usuarioEntity) {
		this.perfilRepository.findByCode(PERFIL_USUARIO_CODE).ifPresent(perfil -> {
			UsuarioPerfilEntity usuarioPerfilEntity = new UsuarioPerfilEntity();
				usuarioPerfilEntity.setUsuarioEntity(usuarioEntity);
				usuarioPerfilEntity.setPerfilEntity(perfil);
			this.usuarioPerfilRepository.save(usuarioPerfilEntity);
		});
	}

}
