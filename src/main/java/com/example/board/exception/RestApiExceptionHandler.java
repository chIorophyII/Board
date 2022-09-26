package com.example.board.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestApiExceptionHandler {

    private ResponseEntity<StatusMessage> response(Exception ex) {
        StatusMessage message = new StatusMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        message.setHttpStatus(StatusMessage.StatusEnum.BAD_REQUEST);
        message.setMessage(ex.getMessage());

        return new ResponseEntity<>(message, headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StatusMessage> handleApiRequestException(IllegalArgumentException ex) {
        return response(ex);
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<StatusMessage> handleApiRequestException(NullPointerException ex) {
        return response(ex);
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus
    public ResponseEntity<StatusMessage> handleApiRequestException(IOException ex) {
        return response(ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StatusMessage> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return response(ex);
    }
}