package com.zappts.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "carta")
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namecard;
    private String edicao;
    private String idioma;
    private Boolean laminada = false;
    private double preco;
    private int cartasrepetidas;

    @ManyToOne
    @JsonIgnoreProperties("carta")
    private Lista lista;

}
