package br.com.quintain.defensiumapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintain.defensiumapi.entity.UsuarioPerfilEntity;

@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfilEntity, Long> {

	List<UsuarioPerfilEntity> findPerfilEntityByUsuarioEntityCode(Long code);
	
}
