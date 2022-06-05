package br.com.ffseguros.apistoragebikes.adapter.presentation.controller;

import br.com.ffseguros.apistoragebikes.application.exception.outsourcing.InvalidOutsourcingAddressException;
import br.com.ffseguros.apistoragebikes.application.exception.outsourcing.InvalidOutsourcingIdException;
import br.com.ffseguros.apistoragebikes.application.exception.outsourcing.InvalidOutsourcingNameException;
import br.com.ffseguros.apistoragebikes.application.exception.outsourcing.InvalidOutsourcingTypeException;
import br.com.ffseguros.apistoragebikes.application.exception.scheduling.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ApplicationError buildApplicationError(final RuntimeException e) {
        return ApplicationError.builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(InvalidOutsourcingIdException.class)
    public ApplicationError handleInvalidOutsourcingIdException(final InvalidOutsourcingIdException e) {
        return buildApplicationError(e);
    }

    @ExceptionHandler(InvalidOutsourcingNameException.class)
    public ApplicationError handleInvalidOutsourcingNameException(final InvalidOutsourcingNameException e) {
        return buildApplicationError(e);
    }

    @ExceptionHandler(InvalidOutsourcingTypeException.class)
    public ApplicationError handleInvalidOutsourcingTypeException(final InvalidOutsourcingTypeException e) {
        return buildApplicationError(e);
    }

    @ExceptionHandler(InvalidOutsourcingAddressException.class)
    public ApplicationError handleInvalidOutsourcingAddressException(final InvalidOutsourcingAddressException e) {
        return buildApplicationError(e);
    }

    @ExceptionHandler(InvalidSchedulingIdException.class)
    public ApplicationError handleInvalidSchedulingIdException(final InvalidSchedulingIdException e) {
        return buildApplicationError(e);
    }

    @ExceptionHandler(InvalidSchedulingCustomerNameException.class)
    public ApplicationError handleInvalidSchedulingCustomerNameException(final InvalidSchedulingCustomerNameException e) {
        return buildApplicationError(e);
    }

    @ExceptionHandler(InvalidSchedulingOutsourcingNameException.class)
    public ApplicationError handleInvalidSchedulingOutsourcingNameException(final InvalidSchedulingOutsourcingNameException e) {
        return buildApplicationError(e);
    }

    @ExceptionHandler(InvalidSchedulingOutsourcingTypeException.class)
    public ApplicationError handleInvalidSchedulingOutsourcingTypeException(final InvalidSchedulingOutsourcingTypeException e) {
        return buildApplicationError(e);
    }

    @ExceptionHandler(InvalidSchedulingScheduleException.class)
    public ApplicationError handleInvalidSchedulingScheduleException(final InvalidSchedulingScheduleException e) {
        return buildApplicationError(e);
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ApplicationError {

    private String message;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime timestamp;

}