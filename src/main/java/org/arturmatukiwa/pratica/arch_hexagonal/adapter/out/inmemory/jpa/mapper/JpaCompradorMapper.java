package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.mapper;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity.JpaCompradorEntity;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Comprador;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Cpf;

public class JpaCompradorMapper {

    public static JpaCompradorEntity toJpaEntity(Comprador domain) {
        return new JpaCompradorEntity(
                domain.getId(),
                domain.getNome(),
                domain.getTelefone(),
                domain.getCpf().getValor()
        );
    }

    public static Comprador toDomain(JpaCompradorEntity entidadeJpa) {
        return new Comprador(
                entidadeJpa.getId(),
                entidadeJpa.getNome(),
                entidadeJpa.getTelefone(),
                new Cpf(entidadeJpa.getCpf())
        );
    }
}
