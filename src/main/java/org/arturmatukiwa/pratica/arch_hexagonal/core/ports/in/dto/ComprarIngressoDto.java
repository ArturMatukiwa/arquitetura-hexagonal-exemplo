package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto;

public record ComprarIngressoDto(
        String cpfComprador,
        String setorIngresso,
        String categoriaIngresso,
        Double porcentagemDesconto,
        Integer quantidadeDesejada
) {
}
