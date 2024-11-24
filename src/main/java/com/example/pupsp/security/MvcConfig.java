package com.example.pupsp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("build/index");
		registry.addViewController("/").setViewName("build/index");
		registry.addViewController("/login").setViewName("build/login");
		registry.addViewController("/register").setViewName("build/register");
	}

}
