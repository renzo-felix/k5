package com.example.demo.services;


import com.example.demo.entities.TipoGrupo;
import com.example.demo.repositories.TipoGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoGrupoService {

    @Autowired
    private TipoGrupoRepository tipoGrupoRepository;

    public List<TipoGrupo> getAllTipoGrupos(){
        return tipoGrupoRepository.findAll();
    }

    public TipoGrupo getTipoGrupoId(Long id){
        return tipoGrupoRepository.findById(id).get();

    }







}
