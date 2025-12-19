package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;

public interface ConsultaIngressoPorIdUseCase {
    Ingresso executarOperacao(Long id);
}
