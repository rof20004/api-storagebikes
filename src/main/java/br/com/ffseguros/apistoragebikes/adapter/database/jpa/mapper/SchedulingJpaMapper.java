package br.com.ffseguros.apistoragebikes.adapter.database.jpa.mapper;

import br.com.ffseguros.apistoragebikes.adapter.database.jpa.model.SchedulingModel;
import br.com.ffseguros.apistoragebikes.application.entity.Scheduling;
import org.springframework.beans.BeanUtils;

public class SchedulingJpaMapper {

    private SchedulingJpaMapper() {}

    public static Scheduling toEntity(final SchedulingModel model) {
        var entity = new Scheduling();
        BeanUtils.copyProperties(model, entity);
        return entity;
    }

    public static SchedulingModel toModel(final Scheduling entity) {
        var model = new SchedulingModel();
        BeanUtils.copyProperties(entity, model);
        return model;
    }

}
