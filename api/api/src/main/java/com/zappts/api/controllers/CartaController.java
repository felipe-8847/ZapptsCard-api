package com.zappts.api.controllers;


import com.zappts.api.models.Carta;
import com.zappts.api.repository.CartaReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carta")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartaController {

    @Autowired
    private CartaReposytory cartaReposytory;

    @GetMapping("/buscaCarta")
    public ResponseEntity<List<Carta>> buscarUsuario(){
        List<Carta> res =  cartaReposytory.findAll();

        if( res != null){

            return  ResponseEntity.status(HttpStatus.OK).body(res);
        }
        return (ResponseEntity<List<Carta>>) ResponseEntity.badRequest();
    }

    @GetMapping("/buscaCarta/name/{namecard}")
    public ResponseEntity<Carta> buscarUsuario(@PathVariable(value = "namecard")  String namecard){

        Carta res = cartaReposytory.findByNamecard(namecard);

        return  ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Carta> salvar(@RequestBody Carta carta){

        return ResponseEntity.status(HttpStatus.OK).body(cartaReposytory.save(carta));
    }


    // Passar o nome da carta para o delete
    @DeleteMapping("/deletar/{namecard}")
    public ResponseEntity<Carta>  deleteCarta (@PathVariable(value = "namecard") String namecard){

        Carta res = cartaReposytory.findByNamecard(namecard);

        if(res != null){
            cartaReposytory.deleteById((long) res.getId());
            return ResponseEntity.ok().build();
        }
            return ResponseEntity.badRequest().build();
    }

/*
    @PutMapping("/atualizar")
    public ResponseEntity<Carta> atualizar(@RequestBody String carta){
        Carta respostaCarta = cartaReposytory.findByNamecard(carta);
        if(respostaCarta.equals(null)){
            return (ResponseEntity<Carta>) ResponseEntity.badRequest();
        }else{
            cartaReposytory.delete(carta);
            return ResponseEntity.status(HttpStatus.OK).body(cartaReposytory.save(carta));
        }
    }*/
}
