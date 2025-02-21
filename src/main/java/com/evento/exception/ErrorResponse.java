package com.evento.exception;

public class ErrorResponse {
    private String message;
    private int errorcode;

    public ErrorResponse(String message, int errorcode) {
        this.message = message;
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }
}
