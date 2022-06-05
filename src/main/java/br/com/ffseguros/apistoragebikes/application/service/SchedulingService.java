package br.com.ffseguros.apistoragebikes.application.service;

import br.com.ffseguros.apistoragebikes.application.entity.Scheduling;
import br.com.ffseguros.apistoragebikes.application.exception.scheduling.*;
import br.com.ffseguros.apistoragebikes.application.port.SchedulingPersistencePort;
import br.com.ffseguros.apistoragebikes.application.usecase.SchedulingUsecase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class SchedulingService implements SchedulingUsecase {

    private final SchedulingPersistencePort schedulingPersistencePort;

    public SchedulingService(final SchedulingPersistencePort schedulingPersistencePort) {
        this.schedulingPersistencePort = schedulingPersistencePort;
    }

    @Override
    public void saveScheduling(Scheduling scheduling) {
        this.validate(scheduling);
        this.schedulingPersistencePort.saveScheduling(scheduling);
    }

    @Override
    public List<Scheduling> getAllScheduling() {
        return this.schedulingPersistencePort.getAllScheduling();
    }

    private void validate(final Scheduling scheduling) {
        this.validateIsValidId(scheduling.getId());
        this.validateCustomerNameIsNotNull(scheduling.getCustomerName());
        this.validateOutsourcingNameIsNotNull(scheduling.getOutsourcingName());
        this.validateOutsourcingTypeIsNotNull(scheduling.getOutsourcingType());
        this.validateIsValidSchedule(scheduling.getSchedule());
    }

    private void validateIsValidId(final String id) {
        try {
            UUID.fromString(id);
        } catch (Exception e) {
            throw new InvalidSchedulingIdException();
        }
    }

    private void validateCustomerNameIsNotNull(final String customerName) {
        Optional.ofNullable(customerName).filter(Predicate.not(String::isEmpty)).orElseThrow(InvalidSchedulingCustomerNameException::new);
    }

    private void validateOutsourcingNameIsNotNull(final String outsourcingName) {
        Optional.ofNullable(outsourcingName).filter(Predicate.not(String::isEmpty)).orElseThrow(InvalidSchedulingOutsourcingNameException::new);
    }

    private void validateOutsourcingTypeIsNotNull(final String outsourcingType) {
        Optional.ofNullable(outsourcingType).filter(Predicate.not(String::isEmpty)).orElseThrow(InvalidSchedulingOutsourcingTypeException::new);
    }

    private void validateIsValidSchedule(final LocalDateTime schedule) {
        if (schedule == null || schedule.isBefore(LocalDateTime.now())) {
            throw new InvalidSchedulingScheduleException();
        }
    }

}
