package com.parroquias.parroquia_ws.parroquia_ws.baptism.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.parroquias.parroquia_ws.parroquia_ws.baptism.dto.ListBaptimsRequestDto;
import com.parroquias.parroquia_ws.parroquia_ws.baptism.dto.ListBaptimsResultDto;
import com.parroquias.parroquia_ws.parroquia_ws.baptism.entities.Baptism;
import com.parroquias.parroquia_ws.parroquia_ws.baptism.mapper.ListBaptismMapper;
import com.parroquias.parroquia_ws.parroquia_ws.baptism.repositories.BaptismRepository;
import com.parroquias.parroquia_ws.parroquia_ws.baptism.services.BaptimsService;
import com.parroquias.parroquia_ws.parroquia_ws.common.model.ListResponse;
import com.parroquias.parroquia_ws.parroquia_ws.common.model.PaginationResponse;

@Service
public class BaptimsServiceImpl implements BaptimsService {

    @Autowired
    BaptismRepository baptismRepository;

    @Override
    public ListResponse<ListBaptimsResultDto> listBaptisms(ListBaptimsRequestDto request) {

        int page = request.getPagination().getPageNumber();
        int size = request.getPagination().getPageSize();

        Page<Baptism> baptisms = baptismRepository.findAll(PageRequest.of(page, size));

        List<ListBaptimsResultDto> result = baptisms
                .getContent()
                .stream()
                .map(ListBaptismMapper::toDto)
                .toList();

        PaginationResponse pagination = new PaginationResponse(
                baptisms.getNumber(),
                baptisms.getSize(),
                baptisms.getTotalElements(),
                baptisms.getTotalPages());

        return new ListResponse<>(pagination, result);
    }

}
