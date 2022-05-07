package com.zappts.api.controllers;


import com.zappts.api.models.Lista;
import com.zappts.api.repository.ListaReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ListaController {


    @Autowired
    private ListaReposytory listaReposytory;

    @GetMapping("/busca")
    public ResponseEntity<List<Lista>> buscarLista(){
        List<Lista> res =  listaReposytory.findAll();

        if( res != null){

            return  ResponseEntity.status(HttpStatus.OK).body(res);
        }
        return (ResponseEntity<List<Lista>>) ResponseEntity.badRequest();
    }

    @GetMapping("/busca/nome/{lista}")
    public ResponseEntity<Lista> buscarLista(@PathVariable(value = "lista")  String lista){

        Lista res = listaReposytory.findByNome(lista);

        if(res != null){
            return  ResponseEntity.status(HttpStatus.OK).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Lista> salvar(@RequestBody Lista lista){

        return ResponseEntity.status(HttpStatus.OK).body(listaReposytory.save(lista));
    }

    // Passar o nome da lista para o delete
    @DeleteMapping("/deletar/{lista}")
    public ResponseEntity<Lista>  deletarLista (@PathVariable(value = "lista") String lista){

        Lista res = listaReposytory.findByNome(lista);

        if(res != null){
            listaReposytory.deleteById(res.getId());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
