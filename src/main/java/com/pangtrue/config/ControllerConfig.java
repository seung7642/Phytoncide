package com.pangtrue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pangtrue.controller.RegisterController;

@Configuration
public class ControllerConfig {

    @Bean
    public RegisterController registerController() {
        return new RegisterController();
    }
}
