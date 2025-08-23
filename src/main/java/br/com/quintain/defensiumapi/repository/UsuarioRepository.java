package br.com.quintain.defensiumapi.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quintain.defensiumapi.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	UsuarioEntity findByCodePublic(UUID codePublic);

	Optional<UsuarioEntity> findByUsuario(String usuario);

	boolean existsByUsuario(String usuario);

}
