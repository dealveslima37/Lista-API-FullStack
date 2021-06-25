package com.vfoprojects.listaapi.controller.exceptions;

public class FieldMessage {

    private String message;

    public FieldMessage() {

    }

    public FieldMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
