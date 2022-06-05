package br.com.ffseguros.apistoragebikes.application.service;

import br.com.ffseguros.apistoragebikes.application.entity.Outsourcing;
import br.com.ffseguros.apistoragebikes.application.enums.OutsourcingType;
import br.com.ffseguros.apistoragebikes.application.exception.outsourcing.*;
import br.com.ffseguros.apistoragebikes.application.port.OutsourcingPersistencePort;
import br.com.ffseguros.apistoragebikes.application.usecase.OutsourcingUsecase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class OutsourcingService implements OutsourcingUsecase {

    private final OutsourcingPersistencePort outsourcingPersistencePort;

    public OutsourcingService(final OutsourcingPersistencePort outsourcingPersistencePort) {
        this.outsourcingPersistencePort = outsourcingPersistencePort;
    }

    @Override
    public void saveOutsourcing(final Outsourcing outsourcing) {
        this.validate(outsourcing);
        this.outsourcingPersistencePort.saveOutsourcing(outsourcing);
    }

    @Override
    public List<Outsourcing> getAllOutsourcing() {
        return this.outsourcingPersistencePort.getAllOutsourcing();
    }

    private void validate(final Outsourcing outsourcing) {
        this.validateIsValidId(outsourcing.getId());
        this.validateNameIsNotNull(outsourcing.getName());
        this.validateAddressIsNotNull(outsourcing.getAddress());
        this.validateTypeIsNotNull(outsourcing.getType());
        this.validateIsValidSchedule(outsourcing.getSchedule());
    }

    private void validateIsValidId(final String id) {
        try {
            UUID.fromString(id);
        } catch (Exception e) {
            throw new InvalidOutsourcingIdException();
        }
    }

    private void validateNameIsNotNull(final String name) {
        Optional.ofNullable(name).filter(Predicate.not(String::isEmpty)).orElseThrow(InvalidOutsourcingNameException::new);
    }

    private void validateAddressIsNotNull(final String address) {
        Optional.ofNullable(address).filter(Predicate.not(String::isEmpty)).orElseThrow(InvalidOutsourcingAddressException::new);
    }

    private void validateTypeIsNotNull(final OutsourcingType type) {
        if (type == null) {
            throw new InvalidOutsourcingTypeException();
        }
    }

    private void validateIsValidSchedule(final LocalDateTime schedule) {
        if (schedule == null || schedule.isBefore(LocalDateTime.now())) {
            throw new InvalidOutsourcingScheduleException();
        }
    }

}
