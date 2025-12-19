package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Categoria;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Setor;

public record CadastrarIngressoDto(
        Double precoIntegral,
        Integer quantidadeTotal,
        Categoria categoria,
        Setor setor,
        Boolean meiaEntrada
) {
}
