package br.cefetrj.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class PerfilUsuario extends GenericEntity {

    private String nome;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "perfil_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> perfis;

    public PerfilUsuario() {

    }

    public PerfilUsuario(Long id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}