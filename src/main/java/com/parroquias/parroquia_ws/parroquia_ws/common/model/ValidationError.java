package com.parroquias.parroquia_ws.parroquia_ws.common.model;

public record ValidationError(
        String field,
        Object rejectedValue,
        String message) {
}
