package com.parroquias.parroquia_ws.parroquia_ws.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PaginationResponse {

    Integer pageNumber;
    Integer pageSize;
    Long total;
    Integer totalPages;

}
