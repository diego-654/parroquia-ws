package com.parroquias.parroquia_ws.parroquia_ws.baptism.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListBaptimsResultDto {
    private Long id;
    private Long count;
    private Integer fojas;
    private Integer number;
    private LocalDate date;
    private String lastName;
    private String name;
    private String officiant;
}
