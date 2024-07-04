package com.conching.APPchara.NotFoundException;

public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(Long id){
        super("Could not found user with" + id);
    }
}
