package br.com.ffseguros.apistoragebikes.application.exception.outsourcing;

public class InvalidOutsourcingAddressException extends RuntimeException {

    public InvalidOutsourcingAddressException() {
        super("outsourcing address is required");
    }

}
