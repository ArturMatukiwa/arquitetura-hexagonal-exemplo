package org.arturmatukiwa.pratica.arch_hexagonal.core.exception;

public class PropriedadeInvalidaException extends RuntimeException {
    public PropriedadeInvalidaException() {
        super("Propriedade inválida");
    }

    public PropriedadeInvalidaException(String message) {
        super(message);
    }
}
