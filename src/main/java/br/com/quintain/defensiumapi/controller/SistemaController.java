package br.com.quintain.defensiumapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintain.defensiumapi.entity.SistemaEntity;
import br.com.quintain.defensiumapi.service.SistemaService;


@RestController
@RequestMapping("/defensium/sistema")
@CrossOrigin("*")
public class SistemaController {

    private final SistemaService sistemaService;

    public SistemaController(SistemaService sistemaService) {
        this.sistemaService = sistemaService;
    }

    @PostMapping
    public SistemaEntity createOne(@RequestBody SistemaEntity sistemaEntity) {
        return this.sistemaService.createOne(sistemaEntity);
    }

    @GetMapping
    public List<SistemaEntity> recuperarTodos() {
        return this.sistemaService.findAll();
    }

}
