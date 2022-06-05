package br.com.ffseguros.apistoragebikes.application.exception.outsourcing;

public class InvalidOutsourcingTypeException extends RuntimeException {

    public InvalidOutsourcingTypeException() {
        super("outsourcing type is invalid");
    }

}
