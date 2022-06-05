package br.com.ffseguros.apistoragebikes.adapter.database.jpa;

import br.com.ffseguros.apistoragebikes.adapter.database.jpa.mapper.OutsourcingJpaMapper;
import br.com.ffseguros.apistoragebikes.adapter.database.jpa.repository.OutsourcingRepository;
import br.com.ffseguros.apistoragebikes.application.entity.Outsourcing;
import br.com.ffseguros.apistoragebikes.application.port.OutsourcingPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OutsourcingPersistenceJpaAdapter implements OutsourcingPersistencePort {

    private final OutsourcingRepository outsourcingRepository;

    @Override
    public void saveOutsourcing(final Outsourcing outsourcing) {
        var model = OutsourcingJpaMapper.toModel(outsourcing);
        this.outsourcingRepository.save(model);
    }

    @Override
    public List<Outsourcing> getAllOutsourcing() {
        var models = this.outsourcingRepository.findAll();
        return models.stream().map(OutsourcingJpaMapper::toEntity).collect(Collectors.toList());
    }

}
