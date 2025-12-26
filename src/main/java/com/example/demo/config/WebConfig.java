package com.example.demo.config;

import com.example.demo.servlet.SimpleEchoServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public ServletRegistrationBean<SimpleEchoServlet> simpleEchoServletRegistrationBean() {
        ServletRegistrationBean<SimpleEchoServlet> bean = new ServletRegistrationBean<>(
                new SimpleEchoServlet(), "/simple-echo");
        return bean;
    }
}