package br.com.quintain.defensiumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintain.defensiumapi.entity.PerfilEntity;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> { }
