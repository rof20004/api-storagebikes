package br.com.ffseguros.apistoragebikes.adapter.database.jpa;

import br.com.ffseguros.apistoragebikes.adapter.database.jpa.model.OutsourcingModel;
import br.com.ffseguros.apistoragebikes.adapter.database.jpa.repository.OutsourcingRepository;
import br.com.ffseguros.apistoragebikes.application.entity.Outsourcing;
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
class OutsourcingPersistenceJpaAdapterTest {

    @Mock
    private OutsourcingRepository outsourcingRepository;

    @Test
    void shouldSaveOutsourcing() {
        when(outsourcingRepository.save(any())).thenReturn(null);

        var outsourcing = Outsourcing.builder()
                .id(UUID.randomUUID().toString())
                .name("Garage Fake")
                .address("Avenue Laguna")
                .schedule(LocalDateTime.now())
                .build();

        var outsourcingPersistenceJpaAdapter = new OutsourcingPersistenceJpaAdapter(outsourcingRepository);

        assertDoesNotThrow(() -> outsourcingPersistenceJpaAdapter.saveOutsourcing(outsourcing));
    }

    @Test
    void shouldGetAllOutsourcing() {
        var modelOne = OutsourcingModel.builder()
                .id(UUID.randomUUID().toString())
                .name("Garage Fake One")
                .address("Avenue Laguna")
                .schedule(LocalDateTime.now())
                .build();

        var modelTwo = OutsourcingModel.builder()
                .id(UUID.randomUUID().toString())
                .name("Garage Fake Two")
                .address("Avenue Laguna")
                .schedule(LocalDateTime.now())
                .build();

        when(outsourcingRepository.findAll()).thenReturn(List.of(modelOne, modelTwo));

        var outsourcingPersistenceJpaAdapter = new OutsourcingPersistenceJpaAdapter(outsourcingRepository);

        assertEquals(2, outsourcingPersistenceJpaAdapter.getAllOutsourcing().size());
    }

}
