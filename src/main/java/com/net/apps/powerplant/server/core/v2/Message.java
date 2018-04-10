package com.net.apps.powerplant.server.core.v2;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class Message {

    private long id;

    @Setter
    private String message;

    @Setter
    protected String version;

    private LocalDateTime timestamp;

    public Message() {
        this.message = "OK";
        this.version = "v2";
        this.timestamp = LocalDateTime.now();
    }

    public Message(long id) {
        this();
        this.id = id;
    }
}
