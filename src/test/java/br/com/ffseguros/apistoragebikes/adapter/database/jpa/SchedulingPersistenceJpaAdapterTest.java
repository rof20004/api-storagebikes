package br.com.ffseguros.apistoragebikes.adapter.database.jpa;

import br.com.ffseguros.apistoragebikes.adapter.database.jpa.model.SchedulingModel;
import br.com.ffseguros.apistoragebikes.adapter.database.jpa.repository.SchedulingRepository;
import br.com.ffseguros.apistoragebikes.application.entity.Scheduling;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class SchedulingPersistenceJpaAdapterTest {

    @Mock
    private SchedulingRepository schedulingRepository;

    @Test
    void shouldSaveScheduling() {
        when(schedulingRepository.save(any())).thenReturn(null);

        var scheduling = Scheduling.builder()
                .id(UUID.randomUUID().toString())
                .customerName("Customer Fake")
                .outsourcingName("Garage Fake")
                .schedule(LocalDateTime.now())
                .build();

        var schedulingPersistenceJpaAdapter = new SchedulingPersistenceJpaAdapter(schedulingRepository);

        assertDoesNotThrow(() -> schedulingPersistenceJpaAdapter.saveScheduling(scheduling));
    }

    @Test
    void shouldGetAllScheduling() {
        var modelOne = SchedulingModel.builder()
                .id(UUID.randomUUID().toString())
                .customerName("Customer Fake One")
                .outsourcingName("Garage Fake One")
                .schedule(LocalDateTime.now())
                .build();

        var modelTwo = SchedulingModel.builder()
                .id(UUID.randomUUID().toString())
                .customerName("Customer Fake Two")
                .outsourcingName("Garage Fake Two")
                .schedule(LocalDateTime.now())
                .build();

        when(schedulingRepository.findAll()).thenReturn(List.of(modelOne, modelTwo));

        var schedulingPersistenceJpaAdapter = new SchedulingPersistenceJpaAdapter(schedulingRepository);

        assertEquals(2, schedulingPersistenceJpaAdapter.getAllScheduling().size());
    }

}
