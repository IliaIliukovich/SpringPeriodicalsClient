package com.epam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "com.epam")
public class AppConfig {

    private final Environment env;

    @Autowired
    public AppConfig(Environment env) { this.env = env; }

}
