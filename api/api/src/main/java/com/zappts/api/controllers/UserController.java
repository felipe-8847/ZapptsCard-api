package com.zappts.api.controllers;

import com.zappts.api.models.Lista;
import com.zappts.api.models.User;
import com.zappts.api.repository.UserReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController{

    @Autowired
    private UserReposytory userReposytory;

    @GetMapping("/buscar/usuarios")
    public ResponseEntity<List<User>> buscarUsuario(){
        List<User> res =  userReposytory.findAll();

        if( res != null){

            return  ResponseEntity.status(HttpStatus.OK).body(res);
        }
        return (ResponseEntity<List<User>>) ResponseEntity.badRequest();
    }

    @GetMapping("/buscaUsuario/{usuario}")
    public ResponseEntity<User> buscarUsuario(@PathVariable(value = "usuario") String usuario){
        return  ResponseEntity.status(HttpStatus.OK).body(userReposytory.findByName(usuario));
    }

    @PostMapping ("/cadastrar")
    public ResponseEntity<User> salvar(@RequestBody User usuario){

        return ResponseEntity.status(HttpStatus.OK).body(userReposytory.save(usuario));
    }

    // Passar o nome do usuario para o delete
    @DeleteMapping("/deletar/{usuario}")
    public ResponseEntity<User>  deletarUsuario (@PathVariable(value = "usuario") String usuario){

        User res = userReposytory.findByName(usuario);

        if(res != null){
            userReposytory.deleteById(res.getId());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
