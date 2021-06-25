package com.vfoprojects.listaapi.service.exceptions;

public class ItemNotFoundException extends RuntimeException {
    
    public ItemNotFoundException(String msg){
        super(msg);
    }

}
