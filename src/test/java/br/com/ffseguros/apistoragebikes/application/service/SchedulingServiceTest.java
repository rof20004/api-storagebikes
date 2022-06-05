package br.com.ffseguros.apistoragebikes.application.service;

import br.com.ffseguros.apistoragebikes.application.entity.Scheduling;
import br.com.ffseguros.apistoragebikes.application.enums.OutsourcingType;
import br.com.ffseguros.apistoragebikes.application.exception.scheduling.*;
import br.com.ffseguros.apistoragebikes.application.port.SchedulingPersistencePort;
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

class SchedulingServiceTest {

    @Mock
    private SchedulingPersistencePort schedulingPersistencePort;

    @BeforeEach
    void setup() {
        this.schedulingPersistencePort = mock(SchedulingPersistencePort.class);
    }

    @Test
    void shouldSaveScheduling() {
        doNothing().when(schedulingPersistencePort).saveScheduling(any());

        var scheduling = Scheduling.builder()
                .id(UUID.randomUUID().toString())
                .customerName("Customer Fake")
                .outsourcingName("Garage Fake")
                .outsourcingType(OutsourcingType.SHOP.name())
                .schedule(LocalDateTime.of(Character.MAX_VALUE, Month.DECEMBER, 31, 23, 59))
                .build();

        var schedulingService = new SchedulingService(schedulingPersistencePort);

        assertDoesNotThrow(() -> schedulingService.saveScheduling(scheduling));
    }

    @Test
    void shouldThrowExceptionsWhileValidatingSaveScheduling() {
        var schedulingService = new SchedulingService(schedulingPersistencePort);

        var scheduling = Scheduling.builder().build();
        assertThrows(InvalidSchedulingIdException.class, () -> schedulingService.saveScheduling(scheduling));

        scheduling.setId(UUID.randomUUID().toString());
        assertThrows(InvalidSchedulingCustomerNameException.class, () -> schedulingService.saveScheduling(scheduling));

        scheduling.setCustomerName("Customer Fake");
        assertThrows(InvalidSchedulingOutsourcingNameException.class, () -> schedulingService.saveScheduling(scheduling));

        scheduling.setOutsourcingName("Garage Fake");
        assertThrows(InvalidSchedulingOutsourcingTypeException.class, () -> schedulingService.saveScheduling(scheduling));

        scheduling.setOutsourcingType(OutsourcingType.SHOP.name());
        assertThrows(InvalidSchedulingScheduleException.class, () -> schedulingService.saveScheduling(scheduling));
    }

    @Test
    void shouldGetAllScheduling() {
        var schedulingOne = Scheduling.builder().outsourcingName("Garage Fake One").build();
        var schedulingTwo = Scheduling.builder().outsourcingName("Garage Fake Two").build();
        when(schedulingPersistencePort.getAllScheduling()).thenReturn(List.of(schedulingOne, schedulingTwo));

        var schedulingService = new SchedulingService(schedulingPersistencePort);

        assertEquals(2, schedulingService.getAllScheduling().size());
    }

}
