package br.com.ffseguros.apistoragebikes.adapter.database.jpa.mapper;

import br.com.ffseguros.apistoragebikes.adapter.database.jpa.model.OutsourcingModel;
import br.com.ffseguros.apistoragebikes.application.entity.Outsourcing;
import org.springframework.beans.BeanUtils;

public class OutsourcingJpaMapper {

    private OutsourcingJpaMapper() {}

    public static Outsourcing toEntity(final OutsourcingModel model) {
        var entity = new Outsourcing();
        BeanUtils.copyProperties(model, entity);
        return entity;
    }

    public static OutsourcingModel toModel(final Outsourcing entity) {
        var model = new OutsourcingModel();
        BeanUtils.copyProperties(entity, model);
        return model;
    }

}
