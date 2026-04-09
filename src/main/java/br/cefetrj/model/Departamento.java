package br.cefetrj.model;

import jakarta.persistence.Entity;

@Entity
public class Departamento extends GenericEntity {

    private String nome;

    public Departamento() {

    }

    Departamento(Long id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
