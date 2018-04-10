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

@Configuration
@SwaggerDefinition(securityDefinition = @SecurityDefinition(
        apiKeyAuthDefinitions = {
                @ApiKeyAuthDefinition(
                        in = ApiKeyAuthDefinition.ApiKeyLocation.HEADER,
                        key = "api_key",
                        name = "api_key")},
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

//        io.swagger.models.Info info = new io.swagger.models.Info()
//                .title("Swagger Sample App")
//                .description("This is a sample server Petstore server.  You can find out more about Swagger " +
//                        "at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, " +
//                        "you can use the api key `special-key` to test the authorization filters.")
//                .termsOfService("http://helloreverb.com/terms/")
//                .contact(new io.swagger.models.Contact()
//                        .email("apiteam@swagger.io"))
//                .license(new io.swagger.models.License()
//                        .name("Apache 2.0")
//                        .url("http://www.apache.org/licenses/LICENSE-2.0.html"));
//
//        Swagger swagger = beanConfig.getSwagger();
//        swagger.info(info);
//        swagger.externalDocs(new io.swagger.models.ExternalDocs("Find out more about Swagger", "http://swagger.io"));
//        swagger.securityDefinition("api_key", new io.swagger.models.auth.ApiKeyAuthDefinition("api_key", In.HEADER));
//        swagger.securityDefinition("petstore_auth",
//                new io.swagger.models.auth.OAuth2Definition()
//                        .implicit("http://petstore.swagger.io/api/oauth/dialog")
//                        .scope("read:pets", "read your pets")
//                        .scope("write:pets", "modify pets in your account"));
//        swagger.tag(new io.swagger.models.Tag()
//                .name("pet")
//                .description("Everything about your Pets")
//                .externalDocs(new io.swagger.models.ExternalDocs("Find out more", "http://swagger.io")));
//        swagger.tag(new io.swagger.models.Tag()
//                .name("store")
//                .description("Access to Petstore orders"));
//        swagger.tag(new io.swagger.models.Tag()
//                .name("user")
//                .description("Operations about user")
//                .externalDocs(new io.swagger.models.ExternalDocs("Find out more about our store", "http://swagger.io")));

        return beanConfig;
    }
}
