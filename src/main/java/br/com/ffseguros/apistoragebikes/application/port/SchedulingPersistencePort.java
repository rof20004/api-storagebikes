package br.com.ffseguros.apistoragebikes.application.port;

import br.com.ffseguros.apistoragebikes.application.entity.Scheduling;

import java.util.List;

public interface SchedulingPersistencePort {

    void saveScheduling(final Scheduling scheduling);

    List<Scheduling> getAllScheduling();

}
