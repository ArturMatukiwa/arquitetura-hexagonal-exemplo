package org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto;

public record ConsultaIngressoDto(
        Long id,
        Double preco,
        Integer quantidadeDisponivel,
        String categoria,
        String setor,
        Boolean meiaEntrada
) {
}
