package com.net.apps.powerplant.server.core.v3;

import lombok.Getter;

@Getter
public class Message extends com.net.apps.powerplant.server.core.v2.Message{
    public Message() {
        super();
        setVersion("v3");
    }

    public Message(long id, String message) {
        super(id);
        setVersion("v3");
        setMessage(message);
    }
}
