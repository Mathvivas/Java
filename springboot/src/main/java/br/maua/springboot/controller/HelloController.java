package br.maua.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController         // Marcar que a Classe é um Controller e que retornará somente texto
public class HelloController {

    @GetMapping("/")             // Retorna a mensagem no Browser
    public String helloMessage() {
        return "Hello, Digital Innovation One!";
    }
}
