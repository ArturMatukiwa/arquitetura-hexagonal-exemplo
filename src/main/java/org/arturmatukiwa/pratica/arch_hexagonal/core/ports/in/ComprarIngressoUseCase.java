package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.vendaIngresso.Venda;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto.ComprarIngressoDto;

public interface ComprarIngressoUseCase {
    Venda executarOperacao(ComprarIngressoDto request);
}
