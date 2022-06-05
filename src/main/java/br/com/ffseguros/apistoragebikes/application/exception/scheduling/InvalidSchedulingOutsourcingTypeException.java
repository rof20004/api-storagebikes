package br.com.ffseguros.apistoragebikes.application.exception.scheduling;

public class InvalidSchedulingOutsourcingTypeException extends RuntimeException {

    public InvalidSchedulingOutsourcingTypeException() {
        super("scheduling outsourcing type is invalid");
    }

}
