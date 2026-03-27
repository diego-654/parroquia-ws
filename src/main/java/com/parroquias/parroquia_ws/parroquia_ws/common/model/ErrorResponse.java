package com.parroquias.parroquia_ws.parroquia_ws.common.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private static final boolean state = false;
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private String errorCode;
    private List<ValidationError> validationErrors;

    public ErrorResponse(int status, String error, String message, String path, String errorCode,
            List<ValidationError> validationErrors) {
        this(LocalDateTime.now().toString(), status, error, message, path, errorCode, validationErrors);
    }
}
