package br.com.ffseguros.apistoragebikes.adapter.presentation.controller.mapper;

import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto.OutsourcingResponse;
import br.com.ffseguros.apistoragebikes.application.entity.Outsourcing;
import org.springframework.beans.BeanUtils;

public class OutsourcingDtoMapper {

    private OutsourcingDtoMapper() {}

    public static OutsourcingResponse toResponse(final Outsourcing entity) {
        var response = new OutsourcingResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

}
