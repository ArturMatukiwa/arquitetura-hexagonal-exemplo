package org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.controller;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.VendaIngressoRealizadaDto;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto.mapper.VendaMapper;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.vendaIngresso.Venda;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.ComprarIngressoUseCase;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto.ComprarIngressoDto;
import org.arturmatukiwa.pratica.arch_hexagonal.core.service.ComprarIngressoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    private static final Logger LOG = LoggerFactory.getLogger(VendaController.class);
    private final VendaMapper vendaMapper;
    private final ComprarIngressoService comprarIngresso;

    public VendaController(VendaMapper vendaMapper, ComprarIngressoService comprarIngresso) {
        this.vendaMapper     = vendaMapper;
        this.comprarIngresso = comprarIngresso;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VendaIngressoRealizadaDto> realizarVendaIngresso(
            @RequestBody ComprarIngressoDto request
    ) {
        LOG.info("Realizando venda de ingresso...");
        Venda vendaRealizada = comprarIngresso.executarOperacao(request);
        return ResponseEntity.status(200).body(vendaMapper.toDto(vendaRealizada));
    }
}
