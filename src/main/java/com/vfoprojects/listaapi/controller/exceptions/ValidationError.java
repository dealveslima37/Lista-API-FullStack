package com.vfoprojects.listaapi.controller.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getErros() {
        return this.erros;
    }

    public void addError(String messagem) {
        erros.add(new FieldMessage(messagem));
    }
    
}
