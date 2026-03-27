package com.parroquias.parroquia_ws.parroquia_ws.common.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SuccessResponse<T> {

    private boolean state;
    private String timestamp;
    private int status;
    private String message;
    private T data;

    public SuccessResponse(int status, String message, T data) {
        this(true, LocalDateTime.now().toString(), status, message, data);
    }

}
