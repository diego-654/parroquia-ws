package com.parroquias.parroquia_ws.parroquia_ws.baptism.mapper;

import com.parroquias.parroquia_ws.parroquia_ws.baptism.dto.ListBaptimsResultDto;
import com.parroquias.parroquia_ws.parroquia_ws.baptism.entities.Baptism;

public class ListBaptismMapper {

    public static ListBaptimsResultDto toDto(Baptism entity) {
        ListBaptimsResultDto dto = new ListBaptimsResultDto();
        dto.setId(entity.getId() != null ? entity.getId() : null);
        dto.setCount(entity.getCount());
        dto.setFojas(entity.getFojas());
        dto.setNumber(entity.getNumber());
        dto.setDate(entity.getDate());
        if (entity.getBaptizedPerson() != null) {
            dto.setLastName(entity.getBaptizedPerson().getLastName());
            dto.setName(entity.getBaptizedPerson().getName());
        }
        dto.setOfficiant(entity.getOfficiant());
        return dto;
    }

}
