package com.parroquias.parroquia_ws.parroquia_ws.baptism.dto;

import com.parroquias.parroquia_ws.parroquia_ws.common.model.PaginationRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ListBaptimsRequestDto {

    @NotNull(message = "El numero de pagina es obligatorio")
    @Valid
    PaginationRequest pagination;

}
