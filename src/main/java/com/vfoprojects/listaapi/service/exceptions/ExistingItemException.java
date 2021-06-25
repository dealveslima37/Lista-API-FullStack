package com.vfoprojects.listaapi.service.exceptions;

public class ExistingItemException extends RuntimeException {
    
    public ExistingItemException(String msg){
        super(msg);
    }

}
