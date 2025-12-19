package org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso;

public enum Setor {
    NORTE,
    SUL,
    LESTE,
    OESTE;

    public static Setor fromString(String valorString) {
        String valorFormatado = valorString.toUpperCase();

        return switch (valorFormatado) {
            case "NORTE" -> Setor.NORTE;
            case "SUL"   -> Setor.SUL;
            case "LESTE" -> Setor.LESTE;
            case "OESTE" -> Setor.OESTE;
            default      -> throw new IllegalArgumentException("Não há nenhum setor compativel com: " + valorString);
        };
    }
}
