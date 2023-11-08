package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private TipoGrupo tipoGrupo;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "person_group",
        joinColumns = @JoinColumn(name = "group_id"),
        inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> persons = new HashSet<>();

    // Constructors, getters, and setters
    public Group() {}

    public Group(String name, Set<Person> persons, TipoGrupo tipoGrupo) {
        this.name = name;
        this.persons = persons;
        this.tipoGrupo = tipoGrupo;
    }

    public Long getId() {
        return id;
    }

    public String getName() { 
        return name; 
    }

    @JsonIgnore
    public Set<Person> getPersons() {
        return persons;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public TipoGrupo getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(TipoGrupo tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }
}
