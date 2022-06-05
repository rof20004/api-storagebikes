package br.com.ffseguros.apistoragebikes.application.usecase;

import br.com.ffseguros.apistoragebikes.application.entity.Scheduling;

import java.util.List;

public interface SchedulingUsecase {

    void saveScheduling(final Scheduling scheduling);

    List<Scheduling> getAllScheduling();

}
