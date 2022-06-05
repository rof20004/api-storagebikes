package br.com.ffseguros.apistoragebikes.adapter.presentation.controller.mapper;

import br.com.ffseguros.apistoragebikes.adapter.presentation.controller.dto.SchedulingResponse;
import br.com.ffseguros.apistoragebikes.application.entity.Scheduling;
import org.springframework.beans.BeanUtils;

public class SchedulingDtoMapper {

    private SchedulingDtoMapper() {}

    public static SchedulingResponse toResponse(final Scheduling entity) {
        var response = new SchedulingResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

}
