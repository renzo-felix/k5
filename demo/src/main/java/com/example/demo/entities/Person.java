package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "persons")
    private Set<Group> groups = new HashSet<>();

    // Constructors, getters, and setters
    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() { 
        return name; 
    }

    @JsonIgnore
    public Set<Group> getGroups() {
        return groups;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

}

