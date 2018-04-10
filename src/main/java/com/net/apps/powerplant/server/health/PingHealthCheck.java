package com.net.apps.powerplant.server.health;

import com.codahale.metrics.health.HealthCheck;
import com.net.apps.powerplant.server.core.annotation.HealthBean;
import org.springframework.stereotype.Component;

@Component
@HealthBean("I'am Alive")
public class PingHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
//        return Result.unhealthy("template doesn't include a name");
        return Result.healthy();
    }
}
