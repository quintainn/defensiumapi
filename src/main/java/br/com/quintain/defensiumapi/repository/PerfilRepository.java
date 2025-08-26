package br.com.quintain.defensiumapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintain.defensiumapi.entity.PerfilEntity;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {

    Optional<PerfilEntity> findByCode(Long code);

}
