package com.example.demo.controllers;


import com.example.demo.entities.TipoGrupo;
import com.example.demo.services.TipoGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipogrupo")
public class TipoGrupoController {
    @Autowired
    private TipoGrupoService tipoGrupoService;

    @GetMapping
    public ResponseEntity<List<TipoGrupo>> AllTipoGrupo(){
        List<TipoGrupo> listaTipogrupo = tipoGrupoService.getAllTipoGrupos();
        return ResponseEntity.status(200).body(listaTipogrupo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoGrupo> TipoGrupoId(@PathVariable Long id){
        TipoGrupo Tipogrupoid = tipoGrupoService.getTipoGrupoId(id);
        return ResponseEntity.status(200).body(Tipogrupoid);
    }
}
