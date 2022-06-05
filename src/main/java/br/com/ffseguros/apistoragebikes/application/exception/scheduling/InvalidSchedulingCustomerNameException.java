package br.com.ffseguros.apistoragebikes.application.exception.scheduling;

public class InvalidSchedulingCustomerNameException extends RuntimeException {

    public InvalidSchedulingCustomerNameException() {
        super("scheduling customer name is required");
    }

}
