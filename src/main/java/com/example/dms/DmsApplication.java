package com.example.dms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@MapperScan("com.example.dms.mapper")
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled =true)
public class DmsApplication {

    public static void main(String[] args) {
       SpringApplication.run(DmsApplication.class, args);
    }

}
