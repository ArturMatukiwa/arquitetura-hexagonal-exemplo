package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto;

import java.util.Objects;

public record CadastrarCompradorDto(
        String nome,
        String telefone,
        String cpf
) {
    public CadastrarCompradorDto {
        Objects.requireNonNull(nome, "'nome' possui valor nulo");
        Objects.requireNonNull(telefone, "'telefone' possui valor nulo");
        Objects.requireNonNull(cpf, "'cpf' possui valor nulo");
    }
}
