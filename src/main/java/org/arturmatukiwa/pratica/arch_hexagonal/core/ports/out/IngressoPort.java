package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Categoria;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;
import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Setor;

import java.util.Optional;

public interface IngressoPort {
    Optional<Ingresso> buscarPorId(Long id);

    Ingresso persistir(Ingresso ingresso);

    Optional<Ingresso> buscarIngressosPorSetorECategoria(Setor setor, Categoria categoria, Integer quantidade);

    boolean existePorCategoriaSetorEMeiaEntrada(Categoria categoria, Setor setor, Boolean aBoolean);

    Optional<Ingresso> buscarPorCategoriaSetorEMeiaEntrada(Categoria categoria, Setor setor, Boolean meiaEntrada);
}
