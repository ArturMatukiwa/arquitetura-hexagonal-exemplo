package org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.controller;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.ConsultaIngressoDto;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.mapper.IngressoMapper;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto.CadastrarIngressoDto;
import org.arturmatukiwa.pratica.arch_hexagonal.core.service.ConsultaIngressoPorIdService;
import org.arturmatukiwa.pratica.arch_hexagonal.core.service.DisponibilizarIngressosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ingressos")
public class IngressoController {

    private static final Logger LOG = LoggerFactory.getLogger(IngressoController.class);
    private final IngressoMapper ingressoMapper;
    private final ConsultaIngressoPorIdService consultarIngressoPorId;
    private final DisponibilizarIngressosService disponibilizarIngressos;

    public IngressoController(
             IngressoMapper ingressoMapper,
             ConsultaIngressoPorIdService consultarIngressoPorId,
             DisponibilizarIngressosService disponibilizarIngressos) {
        this.ingressoMapper          = ingressoMapper;
        this.consultarIngressoPorId  = consultarIngressoPorId;
        this.disponibilizarIngressos = disponibilizarIngressos;
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ConsultaIngressoDto> consultarIngressoPorId(
            @PathVariable Long id
    ) {
        LOG.info("Consultado ingresso para o id: {}", id);
        Ingresso ingressoEncontrado = consultarIngressoPorId.executarOperacao(id);
        return ResponseEntity.status(200).body(ingressoMapper.toDto(ingressoEncontrado));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsultaIngressoDto> disponibilizarIngressos(
            @RequestBody CadastrarIngressoDto request
    ) {

        LOG.info("Iniciando a disponibilização de ingressos...");
        Ingresso ingressosDisponibilizados = disponibilizarIngressos.executarOperacao(request);
        return ResponseEntity.status(201).body(ingressoMapper.toDto(ingressosDisponibilizados));
    }
}
