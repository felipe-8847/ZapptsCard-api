package com.zappts.api.controllers;


import com.zappts.api.repository.CartaReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carta")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartaController {

    @Autowired
    private CartaReposytory cartaReposytory;

    @GetMapping("/busca")
    public String getCarta(){
        return  "get com sucesso";
    }
}
