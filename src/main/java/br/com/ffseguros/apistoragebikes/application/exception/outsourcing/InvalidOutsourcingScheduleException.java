package br.com.ffseguros.apistoragebikes.application.exception.outsourcing;

public class InvalidOutsourcingScheduleException extends RuntimeException {

    public InvalidOutsourcingScheduleException() {
        super("outsourcing schedule is invalid");
    }

}
