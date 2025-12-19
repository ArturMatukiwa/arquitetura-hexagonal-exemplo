package org.arturmatukiwa.pratica.arch_hexagonal.core.exception;

public class EntidadeJaExistenteException extends RuntimeException {
    public EntidadeJaExistenteException() {
        super("Entidade já existe no sistema");
    }

    public EntidadeJaExistenteException(String message) {
        super(message);
    }
}
