package com.parroquias.parroquia_ws.parroquia_ws.baptism.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parroquias.parroquia_ws.parroquia_ws.baptism.dto.ListBaptimsRequestDto;
import com.parroquias.parroquia_ws.parroquia_ws.baptism.dto.ListBaptimsResultDto;
import com.parroquias.parroquia_ws.parroquia_ws.baptism.services.BaptimsService;
import com.parroquias.parroquia_ws.parroquia_ws.common.model.ListResponse;
import com.parroquias.parroquia_ws.parroquia_ws.common.model.SuccessResponseEntity;

import jakarta.validation.Valid;

import static com.parroquias.parroquia_ws.parroquia_ws.common.config.CommonPaths.ROOT_API_V1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(ROOT_API_V1)
@RestController
public class BaptismController {

    @Autowired
    BaptimsService baptismService;

    @PostMapping("listar")
    public ResponseEntity<?> listar(@Valid @RequestBody ListBaptimsRequestDto request) {

        ListResponse<ListBaptimsResultDto> response = baptismService.listBaptisms(request);

        return SuccessResponseEntity.builder()
                .data(response)
                .build();

    }

    // private ResponseEntity<?> Validation(BindingResult result) {

    // Map<String, String> errors = new HashMap<>();

    // result.getFieldErrors().forEach(error -> {

    // });

    // return null;

    // }

}
