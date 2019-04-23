package com.bee.sample.ch1.comfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ConfigurationProperties(prefix = "server")

public class ServerConfig {
    private int port;
    private String contextPath;

    public ServerConfig() {
    }
}
