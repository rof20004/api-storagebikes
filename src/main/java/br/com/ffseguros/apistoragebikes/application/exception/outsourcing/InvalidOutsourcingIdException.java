package br.com.ffseguros.apistoragebikes.application.exception.outsourcing;

public class InvalidOutsourcingIdException extends RuntimeException {

    public InvalidOutsourcingIdException() {
        super("outsourcing id is invalid");
    }

}
