package com.qaservices.configs;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.qaservices.controllers.Users;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages = "com.qaservices.controllers")
public class SwaggerConfig extends WebMvcConfigurationSupport {
 
    
     /** The title for the spring boot service to be displayed on swagger UI. */  
    @Value("${swagger.title}")  
    private String title;  
  
    /** The description of the spring boot service. */  
    @Value("${swagger.description}")  
    private String description;  
  
    /** The version of the service. */  
    @Value("${swagger.version}")  
    private String version;  
  
    /** The terms of service url for the service if applicable. */  
    @Value("${swagger.termsOfServiceUrl}")  
    private String termsOfServiceUrl;  
  
    /** The contact name for the service. */  
    @Value("${swagger.contact.name}")  
    private String contactName;  
  
    /** The contact url for the service. */  
    @Value("${swagger.contact.url}")  
    private String contactURL;  
  
    /** The contact email for the service. */  
    @Value("${swagger.contact.email}")  
    private String contactEmail;  
  
    /** The license for the service if applicable. */  
    @Value("${swagger.license}")  
    private String license;  
  
    /** The license url for the service if applicable. */  
    @Value("${swagger.licenseUrl}")  
    private String licenseURL;  
  
    /**  
     * This method will return the Docket API object to swagger which will in turn display the information on the swagger UI.  
     *  
     * Refer the URL http://{ip-address or host-name}:{service.port}/{server.contextPath}/swagger-ui.html  
     *  
     * service.port and server.contextPath are provided in application.properties.  
     * If these properties are not defined in the application.properties then the URL for swagger will be  
     * http://{ip-address or host-name}:8080/swagger-ui.html  
     *  
     * @return the docket  
     */  


    @Bean
    public Docket api() { 
    	Class[] clazz = {Users.class};
        return new Docket(DocumentationType.SWAGGER_2)  .apiInfo(apiInfo()).directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
          .select()           
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                        
          .build()
          .ignoredParameterTypes(clazz);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()              
                .title("REST API")
                .description("Servicesx")               
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


@Bean
public SecurityConfiguration securityInfo() {
    return new SecurityConfiguration(null, null, null, null, "", ApiKeyVehicle.HEADER, "Authorization", "");
}

private ApiKey apiKey() {
    return new ApiKey("Authorization", "Authorization", "header");
}

}
