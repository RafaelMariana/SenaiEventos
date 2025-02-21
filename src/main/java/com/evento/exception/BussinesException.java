package com.evento.exception;

public class BussinesException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    private final int errorcode = 400;

    public BussinesException(String message) {
        super(message);

    }
    public int getErrorcode() {
        return errorcode;
    }
}
