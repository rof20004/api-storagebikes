package br.com.ffseguros.apistoragebikes.application.exception.scheduling;

public class InvalidSchedulingScheduleException extends RuntimeException {

    public InvalidSchedulingScheduleException() {
        super("scheduling schedule is invalid");
    }

}
