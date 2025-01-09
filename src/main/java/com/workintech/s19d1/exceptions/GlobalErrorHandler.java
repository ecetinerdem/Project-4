package com.workintech.s19d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
@Data
@AllArgsConstructor
public class GlobalErrorHandler {
    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException(MovieException movieException) {
        log.error("Movie Error has occurred ", movieException);
        return new ResponseEntity<>(new MovieErrorResponse(movieException.getHttpStatus().value(), movieException.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ActorErrorResponse> handleException(ActorException actorException) {
        log.error("Actor error has occurred ", actorException);
        return  new ResponseEntity<>(new ActorErrorResponse(actorException.getHttpStatus().value(), actorException.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> handleException(Exception exception) {
        log.error("A Global error has occurred ", exception);
        return new ResponseEntity<>(new GlobalErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
