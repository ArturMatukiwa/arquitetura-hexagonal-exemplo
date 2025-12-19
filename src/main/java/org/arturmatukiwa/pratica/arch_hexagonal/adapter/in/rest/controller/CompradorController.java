package org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.controller;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.ConsultaCompradorDto;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.mapper.CompradorMapper;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Comprador;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.CadastrarCompradorUseCase;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto.CadastrarCompradorDto;
import org.arturmatukiwa.pratica.arch_hexagonal.core.service.CadastrarCompradorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compradores")
public class CompradorController {

    private static final Logger LOG = LoggerFactory.getLogger(CompradorController.class);
    private final CompradorMapper compradorMapper;
    private final CadastrarCompradorService cadastrarComprador;

    public CompradorController(CompradorMapper compradorMapper, CadastrarCompradorService cadastrarComprador) {
        this.compradorMapper = compradorMapper;
        this.cadastrarComprador = cadastrarComprador;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsultaCompradorDto> cadastrar(
            @RequestBody CadastrarCompradorDto request
    ) {
        LOG.info("Cadastrando comprador...");
        Comprador compradorCadastrado = cadastrarComprador.executarOperacao(request);
        return ResponseEntity.status(201).body(compradorMapper.toDto(compradorCadastrado));
    }
}
