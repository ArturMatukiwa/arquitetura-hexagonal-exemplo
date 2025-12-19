package org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.controller.handler;

public record ExceptionHandledDto(
        int returnCode,
        String message,
        String dateTime
) {
}
