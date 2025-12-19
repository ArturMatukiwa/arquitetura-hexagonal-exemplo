package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto;

public record CadastrarCompradorDto(
        String nome,
        String telefone,
        String cpf
) {
}
