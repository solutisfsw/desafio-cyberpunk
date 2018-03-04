package com.fabrica;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

//Classe que irá subir a aplicação Rest localmente em http://localhost:8080
//Utilize o endereço http://localhost:8080/clone para fazer as reuisições rest.
@SpringBootApplication
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);

    }

}
