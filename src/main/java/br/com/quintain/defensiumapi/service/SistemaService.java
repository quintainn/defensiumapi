package br.com.quintain.defensiumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.quintain.defensiumapi.entity.SistemaEntity;
import br.com.quintain.defensiumapi.repository.SistemaRepository;

@Service
public class SistemaService {

    private final SistemaRepository sistemaRepository;

    public SistemaService(SistemaRepository sistemaRepository) {
        this.sistemaRepository = sistemaRepository;
    }

    public SistemaEntity createOne(SistemaEntity sistemaEntity) {
        return this.sistemaRepository.save(sistemaEntity);
    }

    public List<SistemaEntity> findAll() {
        return this.sistemaRepository.findAll();
    }

}
