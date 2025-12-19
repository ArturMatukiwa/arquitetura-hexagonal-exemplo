package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Comprador;

import java.util.Optional;

public interface CompradorPort {
    Optional<Comprador> buscarPorCpf(String cpf);

    Comprador persistir(Comprador novoComprador);

    boolean existePorCpf(String cpf);
}
