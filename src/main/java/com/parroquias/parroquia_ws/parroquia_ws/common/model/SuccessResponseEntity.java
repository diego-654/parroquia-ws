package com.parroquias.parroquia_ws.parroquia_ws.common.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.parroquias.parroquia_ws.parroquia_ws.common.config.Constants;

public class SuccessResponseEntity<T> extends ResponseEntity<SuccessResponse<T>> {

    public SuccessResponseEntity(SuccessResponse<T> body, HttpStatus status) {
        super(body, status);
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private HttpStatus httpStatus = HttpStatus.OK;
        private String message = Constants.MENSAJE_SUCCESS;
        private T data;

        public Builder<T> status(HttpStatus status) {
            this.httpStatus = status;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public SuccessResponseEntity<T> build() {
            SuccessResponse<T> response = new SuccessResponse<>(httpStatus.value(), message, data);
            return new SuccessResponseEntity<>(response, httpStatus);
        }
    }

}
