package com.camper.Camper.domain.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceCreationException extends RuntimeException{

    public ResourceCreationException(String message) {
        super(message);
    }
}
