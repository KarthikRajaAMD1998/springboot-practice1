package com.jman.form_management_project.config;

import com.jman.form_management_project.jwt.JWTInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.jman.form_management_project.jwt.JWTInterceptor;


@Configuration
@EnableWebMvc
public class WebConfig implements  WebMvcConfigurer{

	@Autowired
    JWTInterceptor jwti;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwti);
    }
	
//	@Bean
//	@RequestScope
//	public Re getRequestMeta() {
//
//		return new RequestMeta();
//	}
//
//	@Bean
//	public JWTInterceptor jwtInterceptor() {
//		return new JWTInterceptor(getRequestMeta());
//	}
	
}
