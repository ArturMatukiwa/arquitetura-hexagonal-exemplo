package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso.Ingresso;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto.CadastrarIngressoDto;

public interface DisponibilizarIngressosUseCase {
    Ingresso executarOperacao(CadastrarIngressoDto dadosIngresso);
}
