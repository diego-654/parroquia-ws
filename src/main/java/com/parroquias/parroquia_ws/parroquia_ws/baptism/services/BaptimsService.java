package com.parroquias.parroquia_ws.parroquia_ws.baptism.services;

import com.parroquias.parroquia_ws.parroquia_ws.baptism.dto.ListBaptimsRequestDto;
import com.parroquias.parroquia_ws.parroquia_ws.baptism.dto.ListBaptimsResultDto;
import com.parroquias.parroquia_ws.parroquia_ws.common.model.ListResponse;

public interface BaptimsService {

    ListResponse<ListBaptimsResultDto> listBaptisms(ListBaptimsRequestDto request);

}
