package br.cefetrj.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario extends GenericEntity {

    public Usuario(Long id, String email, String senha, boolean ativo) {
        super(id);
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }

    private String email;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private boolean ativo;
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PerfilUsuario> perfis;

    public List<PerfilUsuario> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<PerfilUsuario> perfis) {
        this.perfis = perfis;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}