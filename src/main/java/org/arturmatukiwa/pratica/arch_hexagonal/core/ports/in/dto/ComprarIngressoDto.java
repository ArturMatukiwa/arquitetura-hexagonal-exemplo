package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto;

import java.util.Objects;

public record ComprarIngressoDto(
        String cpfComprador,
        String setorIngresso,
        String categoriaIngresso,
        Double porcentagemDesconto,
        Integer quantidadeDesejada
) {
    public ComprarIngressoDto{
        Objects.requireNonNull(cpfComprador, "'cpfComprador' possui valor nulo");
        Objects.requireNonNull(setorIngresso, "'setorIngresso' possui valor nulo");
        Objects.requireNonNull(categoriaIngresso, "'categoriaIngresso' possui valor nulo");
        Objects.requireNonNull(porcentagemDesconto, "'porcentagemDesconto' possui valor nulo");
        Objects.requireNonNull(quantidadeDesejada, "'quantidadeDesejada' possui valor nulo");
    }
}
