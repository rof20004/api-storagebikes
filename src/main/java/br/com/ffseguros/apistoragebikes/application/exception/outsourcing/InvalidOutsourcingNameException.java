package br.com.ffseguros.apistoragebikes.application.exception.outsourcing;

public class InvalidOutsourcingNameException extends RuntimeException {

    public InvalidOutsourcingNameException() {
        super("outsourcing name is required");
    }

}
