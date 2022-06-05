package br.com.ffseguros.apistoragebikes.application.usecase;

import br.com.ffseguros.apistoragebikes.application.entity.Outsourcing;

import java.util.List;

public interface OutsourcingUsecase {

    void saveOutsourcing(final Outsourcing outsourcing);

    List<Outsourcing> getAllOutsourcing();

}
