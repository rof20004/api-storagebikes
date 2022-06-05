package br.com.ffseguros.apistoragebikes.application.port;

import br.com.ffseguros.apistoragebikes.application.entity.Outsourcing;

import java.util.List;

public interface OutsourcingPersistencePort {

    void saveOutsourcing(final Outsourcing outsourcing);

    List<Outsourcing> getAllOutsourcing();

}
