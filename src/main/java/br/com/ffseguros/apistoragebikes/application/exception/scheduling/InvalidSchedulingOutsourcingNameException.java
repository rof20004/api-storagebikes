package br.com.ffseguros.apistoragebikes.application.exception.scheduling;

public class InvalidSchedulingOutsourcingNameException extends RuntimeException {

    public InvalidSchedulingOutsourcingNameException() {
        super("scheduling outsourcing name is required");
    }

}
