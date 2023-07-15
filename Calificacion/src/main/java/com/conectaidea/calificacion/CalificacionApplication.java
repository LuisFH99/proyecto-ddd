package com.conectaidea.calificacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CalificacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalificacionApplication.class, args);
    }

}
