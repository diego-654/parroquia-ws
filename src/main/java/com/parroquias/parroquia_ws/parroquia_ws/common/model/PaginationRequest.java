package com.parroquias.parroquia_ws.parroquia_ws.common.model;

import com.parroquias.parroquia_ws.parroquia_ws.common.validation.IsRequired;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationRequest {
    @NotNull(message = "El numero de pagina es obligatorio")
    @Min(value = 1, message = "El numero de pagina debe ser mayor a 1")
    @IsRequired
    Integer pageNumber;

    @NotNull(message = "El tamaño de pagina es obligatorio")
    @Min(value = 1, message = "El tamaño de pagina debe ser mayor a 1")
    @IsRequired
    Integer pageSize;

}
