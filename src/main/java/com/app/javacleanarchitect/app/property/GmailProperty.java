package com.app.javacleanarchitect.app.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties(value = "application.gmail")
public class GmailProperty {
    private String host;
    private String username;
    private String password;
    private String sender;
    private String port;
}
