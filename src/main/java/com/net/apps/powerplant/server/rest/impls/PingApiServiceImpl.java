package com.net.apps.powerplant.server.rest.impls;

import com.net.apps.powerplant.server.core.v2.Message;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class PingApiServiceImpl implements PingApiService {
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Message ping(){
        return new Message(counter.incrementAndGet());
    }
}
