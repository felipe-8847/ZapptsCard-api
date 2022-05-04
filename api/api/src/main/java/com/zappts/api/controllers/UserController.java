package com.zappts.api.controllers;

import com.zappts.api.repository.UserReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController{

    @Autowired
    private UserReposytory userReposytory;

    @GetMapping("/busca2")
    public String getCarta(){
        return  "get com sucesso 2";
    }


}
