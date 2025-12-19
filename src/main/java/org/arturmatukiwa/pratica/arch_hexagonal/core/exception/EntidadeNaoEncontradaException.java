package org.arturmatukiwa.pratica.arch_hexagonal.core.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{
    public EntidadeNaoEncontradaException() {
        super("Entidade buscada não foi encontada");
    }

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
