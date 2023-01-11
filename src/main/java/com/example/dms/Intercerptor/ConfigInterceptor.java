package com.example.dms.Intercerptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhouy
 * @date 2021/9/23
 * good 09
 */
@Configuration
public class ConfigInterceptor implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyIntercerptor()).addPathPatterns("/dmsPermission/*");

    }
}
