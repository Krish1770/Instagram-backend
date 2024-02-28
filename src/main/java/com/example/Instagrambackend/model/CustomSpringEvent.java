package com.example.Instagrambackend.model;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CustomSpringEvent extends ApplicationEvent {

    private String message;

    public CustomSpringEvent(Object source) {
        super(source);

    }

}
