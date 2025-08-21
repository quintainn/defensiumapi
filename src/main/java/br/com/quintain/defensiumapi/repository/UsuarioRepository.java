package br.com.quintain.defensiumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.quintain.defensiumapi.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	UsuarioEntity findByCodePublic(String codePublic);

	UsuarioEntity findByUsuario(String usuario);

	boolean existsByUsuario(String usuario);

}
