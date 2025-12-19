package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Categoria;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Setor;

import java.util.Objects;

public record CadastrarIngressoDto(
        Double precoIntegral,
        Integer quantidadeTotal,
        Categoria categoria,
        Setor setor,
        Boolean meiaEntrada
) {
    public CadastrarIngressoDto {
        Objects.requireNonNull(precoIntegral, "'precoIntegral' possui valor nulo");
        Objects.requireNonNull(quantidadeTotal, "'quantidadeTotal' possui valor nulo");
        Objects.requireNonNull(categoria, "'categoria' possui valor nulo");
        Objects.requireNonNull(setor, "'setor' possui valor nulo");
        Objects.requireNonNull(meiaEntrada, "'meiaEntrada' possui valor nulo");
    }
}
