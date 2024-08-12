package com.learning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer{
	 @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	        // JSP View Resolver
	        registry.jsp("/views/",".jsp");
	    }
	    

}
