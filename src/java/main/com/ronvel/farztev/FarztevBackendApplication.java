package com.ronvel.farztev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan(basePackages = "com.ronvel")
public class FarztevBackendApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FarztevBackendApplication.class, args);
    }
    
}
