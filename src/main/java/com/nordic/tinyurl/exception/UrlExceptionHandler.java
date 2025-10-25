package com.nordic.tinyurl.exception;

import com.nordic.tinyurl.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UrlExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(UrlExceptionHandler.class);

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUrl(InvalidUrlException exception) {
        logger.error(exception.getMessage());
        ErrorResponse response = new ErrorResponse("Invalid Url", exception.getMessage());
        return ResponseEntity.internalServerError().body(response);
    }
}
