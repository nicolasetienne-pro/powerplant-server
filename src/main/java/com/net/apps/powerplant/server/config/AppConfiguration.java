package com.net.apps.powerplant.server.config;

import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.*;

@Getter
@Setter
public class AppConfiguration extends Configuration {
    // TODO: implement service configuration

    @NotEmpty
    private String template;

}
