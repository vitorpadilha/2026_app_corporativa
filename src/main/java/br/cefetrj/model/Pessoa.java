package br.cefetrj.model;

public class Pessoa extends EntidadeGenerica {

    private String nome;
    private Long idade;

    public Pessoa(Long id, String nome, Long idade) {
        super(id);
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

}
