package br.com.quintain.defensiumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.quintain.defensiumapi.entity.PerfilEntity;
import br.com.quintain.defensiumapi.repository.PerfilRepository;

@Service
public class PerfilService {

	private PerfilRepository perfilRepository;

	public PerfilService(PerfilRepository perfilRepository) {
		this.perfilRepository = perfilRepository;
	}

	public List<PerfilEntity> findAll() {
		return this.perfilRepository.findAll();
	}

}
