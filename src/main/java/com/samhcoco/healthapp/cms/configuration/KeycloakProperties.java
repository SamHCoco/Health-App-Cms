package com.samhcoco.healthapp.cms.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.keycloak")
public class KeycloakProperties {
    private String baseUrl;
    private String username;
    private String password;
    private String grantType;
    private String realm;
}
