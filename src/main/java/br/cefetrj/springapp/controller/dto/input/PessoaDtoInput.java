package br.cefetrj.springapp.controller.dto.input;

import java.time.LocalDateTime;

import br.cefetrj.springapp.model.Pessoa;
import lombok.Data;

@Data
public class PessoaDtoInput {

    private Long id;

    private String nome;

    private Long cpf;

    private LocalDateTime dataNascimento;

    private String email;

    public Pessoa build() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(this.id);
        pessoa.setNome(this.nome);
        pessoa.setCpf(this.cpf);
        pessoa.setDataNascimento(this.dataNascimento);
        pessoa.setEmail(this.email);
        return pessoa;
    }
}
