package com.parroquias.parroquia_ws.parroquia_ws.common.config;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum Error {
    VALIDATION("ERR-001", "Validation error", HttpStatus.BAD_REQUEST.value()),
    INVALID_JSON("ERR-002", "Invalid JSON", HttpStatus.BAD_REQUEST.value());

    Error(

            String codigo, String nombre,
            int status) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.status = status;
    }

    private final String codigo;
    private final String nombre;
    private final int status;
}
