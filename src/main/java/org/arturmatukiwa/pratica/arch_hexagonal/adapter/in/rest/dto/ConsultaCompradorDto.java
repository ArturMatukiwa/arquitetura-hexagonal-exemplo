package org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.dto;

public record ConsultaCompradorDto(
        Long id,
        String nome,
        String telefone,
        String cpf
) {
}
