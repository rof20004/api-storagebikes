package br.com.ffseguros.apistoragebikes.adapter.database.jpa;

import br.com.ffseguros.apistoragebikes.adapter.database.jpa.mapper.SchedulingJpaMapper;
import br.com.ffseguros.apistoragebikes.adapter.database.jpa.repository.SchedulingRepository;
import br.com.ffseguros.apistoragebikes.application.entity.Scheduling;
import br.com.ffseguros.apistoragebikes.application.port.SchedulingPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SchedulingPersistenceJpaAdapter implements SchedulingPersistencePort {

    private final SchedulingRepository schedulingRepository;

    @Override
    public void saveScheduling(final Scheduling scheduling) {
        var model = SchedulingJpaMapper.toModel(scheduling);
        this.schedulingRepository.save(model);
    }

    @Override
    public List<Scheduling> getAllScheduling() {
        var models = this.schedulingRepository.findAll();
        return models.stream().map(SchedulingJpaMapper::toEntity).collect(Collectors.toList());
    }

}
