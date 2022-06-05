package br.com.ffseguros.apistoragebikes.application.service;

import br.com.ffseguros.apistoragebikes.application.entity.Outsourcing;
import br.com.ffseguros.apistoragebikes.application.enums.OutsourcingType;
import br.com.ffseguros.apistoragebikes.application.exception.outsourcing.*;
import br.com.ffseguros.apistoragebikes.application.port.OutsourcingPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OutsourcingServiceTest {

    @Mock
    private OutsourcingPersistencePort outsourcingPersistencePort;

    @BeforeEach
    void setup() {
        this.outsourcingPersistencePort = mock(OutsourcingPersistencePort.class);
    }

    @Test
    void shouldSaveOutsourcing() {
        doNothing().when(outsourcingPersistencePort).saveOutsourcing(any());

        var outsourcingService = new OutsourcingService(outsourcingPersistencePort);

        var outsourcing = Outsourcing.builder()
                .id(UUID.randomUUID().toString())
                .name("Garage Fake")
                .address("Avenue Laguna")
                .type(OutsourcingType.SHOP)
                .schedule(LocalDateTime.of(Character.MAX_VALUE, Month.DECEMBER, 31, 23, 59))
                .build();

        assertDoesNotThrow(() -> outsourcingService.saveOutsourcing(outsourcing));
    }

    @Test
    void shouldThrowExceptionsWhileValidatingSaveOutsourcing() {
        var outsourcingService = new OutsourcingService(outsourcingPersistencePort);

        var outsourcing = Outsourcing.builder().build();
        assertThrows(InvalidOutsourcingIdException.class, () -> outsourcingService.saveOutsourcing(outsourcing));

        outsourcing.setId(UUID.randomUUID().toString());
        assertThrows(InvalidOutsourcingNameException.class, () -> outsourcingService.saveOutsourcing(outsourcing));

        outsourcing.setName("Garage Fake");
        assertThrows(InvalidOutsourcingAddressException.class, () -> outsourcingService.saveOutsourcing(outsourcing));

        outsourcing.setAddress("Avenue Laguna");
        assertThrows(InvalidOutsourcingTypeException.class, () -> outsourcingService.saveOutsourcing(outsourcing));

        outsourcing.setType(OutsourcingType.INSURANCE);
        assertThrows(InvalidOutsourcingScheduleException.class, () -> outsourcingService.saveOutsourcing(outsourcing));
    }

    @Test
    void shouldGetAllOutsourcing() {
        var outsourcingOne = Outsourcing.builder().name("Garage Fake One").build();
        var outsourcingTwo = Outsourcing.builder().name("Garage Fake Two").build();
        when(outsourcingPersistencePort.getAllOutsourcing()).thenReturn(List.of(outsourcingOne, outsourcingTwo));

        var outsourcingService = new OutsourcingService(outsourcingPersistencePort);

        assertEquals(2, outsourcingService.getAllOutsourcing().size());
    }

}
