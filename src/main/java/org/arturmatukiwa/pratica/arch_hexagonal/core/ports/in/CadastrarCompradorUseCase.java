package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.comprador.Comprador;
import org.arturmatukiwa.pratica.arch_hexagonal.core.ports.in.dto.CadastrarCompradorDto;

public interface CadastrarCompradorUseCase {
    Comprador executarOperacao(CadastrarCompradorDto request);
}
