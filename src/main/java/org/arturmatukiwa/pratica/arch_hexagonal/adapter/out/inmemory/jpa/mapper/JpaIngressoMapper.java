package org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.mapper;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.entity.JpaIngressoEntity;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;

public class JpaIngressoMapper {
    public static JpaIngressoEntity toJpaEntity(Ingresso domain) {
        return new JpaIngressoEntity(
                domain.getId(),
                domain.getPreco(),
                domain.getQuantidadeTotal(),
                domain.getQuantidadeVendida(),
                domain.getCategoria(),
                domain.getSetor(),
                domain.possuiMeiaEntrada()
        );
    };

    public static Ingresso toDomain(JpaIngressoEntity entidadeJpa) {
        return new Ingresso(
                entidadeJpa.getId(),
                entidadeJpa.getPreco(),
                entidadeJpa.getQuantidadeTotal(),
                entidadeJpa.getQuantidadeVendida(),
                entidadeJpa.getCategoria(),
                entidadeJpa.getSetor(),
                entidadeJpa.getMeiaEntrada()
        );
    }
}
