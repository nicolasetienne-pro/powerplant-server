package com.net.apps.powerplant.server.config;

import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.OAuth2Definition;
import io.swagger.annotations.Scope;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.jaxrs.Reader;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.ReaderListener;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.models.SecurityRequirement;
import io.swagger.models.Swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.core.HttpHeaders;

@Configuration
@SwaggerDefinition(securityDefinition = @SecurityDefinition(
        apiKeyAuthDefinitions = {
                @ApiKeyAuthDefinition(
                        in = ApiKeyAuthDefinition.ApiKeyLocation.HEADER,
                        key = "api_key",
                        name = HttpHeaders.AUTHORIZATION)},

        oAuth2Definitions = {
                @OAuth2Definition(
                        key = "plant_auth",
                        authorizationUrl = "http://localhost/api/oauth/dialog",
                        flow = OAuth2Definition.Flow.PASSWORD,
                        scopes = {
                        @Scope(name="read:plants", description = "read your plants"),
                        @Scope(name="write:plants", description = "modify plants in your account")})
        }))
public class SwaggerConfiguration implements ReaderListener {

    @Override
    public void beforeScan(Reader reader, Swagger swagger) {

    }

    @Override
    public void afterScan(Reader reader, Swagger swagger) {
        swagger.addSecurity(new SecurityRequirement().requirement("api_key"));
        swagger.addSecurity(new SecurityRequirement().requirement("plant_auth"));
    }

    @Bean
    public ApiListingResource apiListingResource(){
        return new ApiListingResource();
    }

    @Bean
    public BeanConfig beanConfig(){
        // TODO: use config properties
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("Swagger sample app");
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("com.net.apps.powerplant.server");
        beanConfig.setScan(true);

        return beanConfig;
    }
}
