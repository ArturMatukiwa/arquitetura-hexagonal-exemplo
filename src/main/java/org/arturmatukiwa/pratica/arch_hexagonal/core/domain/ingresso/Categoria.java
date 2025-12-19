package org.arturmatukiwa.pratica.arch_hexagonal.core.domain.ingresso;

public enum Categoria {
    SIMPLES,
    VIP,
    PREMIUM;

    public static Categoria fromString(String valorString) {
        String valorFormatado = valorString.toUpperCase();

        return switch (valorFormatado) {
            case "SIMPLES" -> Categoria.SIMPLES;
            case "VIP"     -> Categoria.VIP;
            case "PREMIUM" -> Categoria.PREMIUM;
            default        -> throw new IllegalArgumentException(
                    "Não há nenhuma cateforia compativel com: " + valorString
            );
        };
    }
}
