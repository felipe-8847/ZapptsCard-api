package com.zappts.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "carta")
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCard;
    private String edicao;
    private Enum idioma;
    private Boolean laminada = false;
    private double preco;
    private int cartasRepetidas;

}
