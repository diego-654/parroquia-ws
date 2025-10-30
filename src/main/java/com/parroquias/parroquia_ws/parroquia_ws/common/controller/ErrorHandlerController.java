package com.parroquias.parroquia_ws.parroquia_ws.common.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.parroquias.parroquia_ws.parroquia_ws.common.config.Error;
import com.parroquias.parroquia_ws.parroquia_ws.common.model.ErrorResponse;
import com.parroquias.parroquia_ws.parroquia_ws.common.model.ValidationError;

@ControllerAdvice
public class ErrorHandlerController {
        // private static final Logger logger =
        // LoggerFactory.getLogger(ErrorHandlerController.class);

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorResponse> handleValidationExceptions(
                        MethodArgumentNotValidException ex, WebRequest request) {

                List<ValidationError> validationErrors = ex.getBindingResult().getFieldErrors().stream()
                                .map(error -> new ValidationError(
                                                error.getField(),
                                                error.getRejectedValue(),
                                                error.getDefaultMessage()))
                                .collect(Collectors.toList());

                ErrorResponse errorResponse = new ErrorResponse(
                                LocalDateTime.now().toString(),
                                HttpStatus.BAD_REQUEST.value(),
                                "Bad Request",
                                "Error de validación en los campos enviados",
                                request.getDescription(false).replace("uri=", ""),
                                Error.VALIDATION.getCodigo(),
                                validationErrors);

                return ResponseEntity.badRequest().body(errorResponse);
        }

        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(
                        HttpMessageNotReadableException ex, WebRequest request) {

                ErrorResponse errorResponse = new ErrorResponse(
                                LocalDateTime.now().toString(),
                                HttpStatus.BAD_REQUEST.value(),
                                "Bad Request",
                                "El cuerpo de la solicitud está vacío o mal formado",
                                request.getDescription(false).replace("uri=", ""),
                                Error.INVALID_JSON.getCodigo(),
                                null);

                return ResponseEntity.badRequest().body(errorResponse);
        }

}