package com.conectaidea.recurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RecursoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecursoApplication.class, args);
    }

}
