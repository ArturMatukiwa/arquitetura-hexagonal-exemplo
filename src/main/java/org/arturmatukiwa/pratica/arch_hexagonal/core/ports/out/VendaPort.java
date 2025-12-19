package org.arturmatukiwa.pratica.arch_hexagonal.core.ports.out;

import org.arturmatukiwa.pratica.arch_hexagonal.core.domain.vendaIngresso.Venda;

public interface VendaPort {

    Venda persistir(Venda venda);
}
