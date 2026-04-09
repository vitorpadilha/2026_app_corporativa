package br.cefetrj.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario extends GenericEntity {

    private String email;
    private String senha;
    private boolean ativo;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "perfil_id"))
    private List<PerfilUsuario> perfis;

    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento departamento;

    public Usuario() {

    }

    public Usuario(Long id, String email, String senha, boolean ativo) {
        super(id);
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}