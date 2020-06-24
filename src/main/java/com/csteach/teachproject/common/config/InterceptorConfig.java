package com.csteach.teachproject.common.config;

import com.csteach.teachproject.common.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor getMyInterceptor(){
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] include={
                "/**"
        };
        String[] exclude={
            "/login","/register","/sendcode","/getuserinfo","/getclasslist","/getallcategory"
        };
        
        registry.addInterceptor(getMyInterceptor())
                .addPathPatterns(include)
                .excludePathPatterns(exclude);
    }
}