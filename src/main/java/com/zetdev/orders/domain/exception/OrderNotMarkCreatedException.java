package com.zetdev.orders.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderNotMarkCreatedException extends RuntimeException {

    public OrderNotMarkCreatedException(String message) {
        super(message);
    }
}
