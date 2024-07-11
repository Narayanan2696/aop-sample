package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class AopExample {
    public static void main(String[] args) {
        System.out.println("Initializing application!!");
        SpringApplication.run(AopExample.class, args);
    }
}
