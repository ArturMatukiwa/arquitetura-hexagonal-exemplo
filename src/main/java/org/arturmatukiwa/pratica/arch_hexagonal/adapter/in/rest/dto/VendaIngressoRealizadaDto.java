package org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto;

import java.time.LocalDateTime;

public record VendaIngressoRealizadaDto(
        Long id,
        String nomeComprador,
        String categoriaIngresso,
        String setorIngresso,
        Double valorPago,
        LocalDateTime horarioVenda
) {
}
