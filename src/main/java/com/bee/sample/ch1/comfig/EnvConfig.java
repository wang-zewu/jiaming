package com.bee.sample.ch1.comfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvConfig {
    @Autowired
    private Environment env;
    public int getServerPort(){
        return env.getProperty("server.port", Integer.class);
    }
}
