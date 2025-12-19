package org.arturmatukiwa.pratica.arch_hexagonal.adapter.in.rest.controller.handler;

import org.arturmatukiwa.pratica.arch_hexagonal.core.exception.EntidadeJaExistenteException;
import org.arturmatukiwa.pratica.arch_hexagonal.core.exception.EntidadeNaoEncontradaException;
import org.arturmatukiwa.pratica.arch_hexagonal.core.exception.IngressosNaoDisponiveisException;
import org.arturmatukiwa.pratica.arch_hexagonal.core.exception.PropriedadeInvalidaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class RestExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<ExceptionHandledDto> handleEntidadeNaoEncontrada(EntidadeNaoEncontradaException exception) {
        gerarLogsDeErro(exception);

        var exceptionResponse = new ExceptionHandledDto(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now().format(DATE_TIME_FORMATTER)
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(PropriedadeInvalidaException.class)
    public ResponseEntity<ExceptionHandledDto> handlePropriedadeInvalida(PropriedadeInvalidaException exception) {
        gerarLogsDeErro(exception);

        var exceptionResponse = new ExceptionHandledDto(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                LocalDateTime.now().format(DATE_TIME_FORMATTER)
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(IngressosNaoDisponiveisException.class)
    public ResponseEntity<ExceptionHandledDto> handleIngressosEsgotados(IngressosNaoDisponiveisException exception) {
        gerarLogsDeErro(exception);

        var exceptionResponse = new ExceptionHandledDto(
                HttpStatus.CONFLICT.value(),
                exception.getMessage(),
                LocalDateTime.now().format(DATE_TIME_FORMATTER)
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponse);
    }

    @ExceptionHandler(EntidadeJaExistenteException.class)
    public ResponseEntity<ExceptionHandledDto> handleIngressosEsgotados(EntidadeJaExistenteException exception) {
        gerarLogsDeErro(exception);

        var exceptionResponse = new ExceptionHandledDto(
                HttpStatus.CONFLICT.value(),
                exception.getMessage(),
                LocalDateTime.now().format(DATE_TIME_FORMATTER)
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionHandledDto> handleIllegalArgumentException(IllegalArgumentException exception) {
        gerarLogsDeErro(exception);

        var exceptionResponse = new ExceptionHandledDto(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                LocalDateTime.now().format(DATE_TIME_FORMATTER)
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionHandledDto> handleNullPointe(NullPointerException exception) {
        gerarLogsDeErro(exception);

        var exceptionResponse = new ExceptionHandledDto(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                LocalDateTime.now().format(DATE_TIME_FORMATTER)
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionHandledDto> handleGenericException(Exception exception) {
        gerarLogsDeErro(exception);

        var exceptionResponse = new ExceptionHandledDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),
                LocalDateTime.now().format(DATE_TIME_FORMATTER)
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    private void gerarLogsDeErro(Exception exception) {
        var stackTrace    = exception.getStackTrace()[0];
        String methodName = stackTrace.getMethodName();

        LOG.error("[ERRO] - Tipo: {}", exception.getClass());
        LOG.error("[ERRO] - Mensagem exception: {}", exception.getMessage());
        LOG.error("[ERRO] - Classe onde ocorreu a exception: {}", stackTrace.getClassName());
        LOG.error("[ERRO] - método onde ocorreu a exception: {}", methodName);
    }
}
