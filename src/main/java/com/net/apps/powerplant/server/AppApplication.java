package com.net.apps.powerplant.server;

import com.codahale.metrics.health.HealthCheck;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.net.apps.powerplant.server.config.AppConfiguration;
import com.net.apps.powerplant.server.config.SpringConfiguration;
import com.net.apps.powerplant.server.core.annotation.HealthBean;
import com.net.apps.powerplant.server.rest.provider.AppAuthFilter;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.ws.rs.Path;
import java.util.EnumSet;
import java.util.Map;

public class AppApplication extends Application<AppConfiguration> {

    ApplicationContext context;

    public static void main(final String[] args) throws Exception {
        new AppApplication().run(args);
    }

    @Override
    public String getName() {
        return "App";
    }

    @Override
    public void initialize(final Bootstrap<AppConfiguration> bootstrap) {
        context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        bootstrap.addBundle(new AssetsBundle("/swagger-ui", "/swagger-ui", "index.html", "Swagger"));
        bootstrap.addBundle(new AssetsBundle("/apidocs", "/apidocs", "index.html", "JavaDoc"));
        bootstrap.setObjectMapper(context.getBean(ObjectMapper.class));
    }

    @Override
    public void run(final AppConfiguration configuration, final Environment environment) {
        // TODO: use config properties
         environment.jersey().setUrlPattern("/api/*");

        initRestResources(environment);

        // accessible via http://localhost:8081/healthcheck
        initStatusResources(environment);

        initRequestFilters(environment);


    }

    private void initRequestFilters(Environment environment) {
        // Enable CORS headers
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");


        //Enable Authentication
        environment.jersey().register(context.getBean(AppAuthFilter.class));
//        environment.jersey().register(context.getBean(AuthDynamicFeature.class));
//        environment.jersey().register(context.getBean(RolesAllowedDynamicFeature.class));
    }

    private void initStatusResources(Environment environment) {
        Map<String, Object> healthBeans = context.getBeansWithAnnotation(HealthBean.class);
        healthBeans.forEach((beanName, bean) -> {
            String name = bean.getClass().getAnnotation(HealthBean.class).value();
            environment.healthChecks().register(StringUtils.isNotBlank(name) ? name : beanName, (HealthCheck) bean);
        });
    }

    /**
     *
     *  Note
     *  A Dropwizard application can contain many resource classes,
     *  each corresponding to its own URI pattern.
     *  Just add another @Path-annotated resource class
     *  and call register with an instance of the new class.
     * @param environment
     */
    private void initRestResources(Environment environment) {
        Map<String, Object> restBeans = context.getBeansWithAnnotation(Path.class);
        restBeans.forEach((beanName, bean) ->  environment.jersey().register(bean));
    }
}
