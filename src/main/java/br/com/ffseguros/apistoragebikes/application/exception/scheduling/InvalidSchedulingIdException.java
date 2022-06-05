package br.com.ffseguros.apistoragebikes.application.exception.scheduling;

public class InvalidSchedulingIdException extends RuntimeException {

    public InvalidSchedulingIdException() {
        super("scheduling id is invalid");
    }

}
