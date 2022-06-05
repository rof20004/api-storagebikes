package br.com.ffseguros.apistoragebikes.adapter.config;

import br.com.ffseguros.apistoragebikes.adapter.database.jpa.OutsourcingPersistenceJpaAdapter;
import br.com.ffseguros.apistoragebikes.adapter.database.jpa.SchedulingPersistenceJpaAdapter;
import br.com.ffseguros.apistoragebikes.application.service.OutsourcingService;
import br.com.ffseguros.apistoragebikes.application.service.SchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeanConfiguration {

    private final OutsourcingPersistenceJpaAdapter outsourcingPersistenceJpaAdapter;
    private final SchedulingPersistenceJpaAdapter schedulingPersistenceJpaAdapter;

    @Bean
    OutsourcingService outsourcingService() {
        return new OutsourcingService(outsourcingPersistenceJpaAdapter);
    }

    @Bean
    SchedulingService schedulingService() {
        return new SchedulingService(schedulingPersistenceJpaAdapter);
    }

}
