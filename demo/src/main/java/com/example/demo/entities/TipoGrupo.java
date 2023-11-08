package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tipo_Grupo")
public class TipoGrupo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    public TipoGrupo(){

    }

    public TipoGrupo(Long id, String tipo){
        this.id = id; this.tipo = tipo;
    }


    //Getter and seters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
