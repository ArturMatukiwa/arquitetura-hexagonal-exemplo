package org.arturmatukiwa.pratica.arch_hexagonal.core.exception;

public class IngressosNaoDisponiveisException extends RuntimeException{
    public IngressosNaoDisponiveisException() {
        super("Ingressos esgotados");
    }

    public IngressosNaoDisponiveisException(String message) {
        super(message);
    }
}
