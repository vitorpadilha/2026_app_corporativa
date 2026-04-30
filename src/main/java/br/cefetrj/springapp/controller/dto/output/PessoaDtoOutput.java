package br.cefetrj.springapp.controller.dto.output;

import java.time.LocalDateTime;

import br.cefetrj.springapp.model.Pessoa;
import lombok.Data;

@Data
public class PessoaDtoOutput {

    private Long id;

    private String nome;

    private Long cpf;

    private LocalDateTime dataNascimento;

    private String email;

    public PessoaDtoOutput(Pessoa p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.cpf = p.getCpf();
        this.dataNascimento = p.getDataNascimento();
        this.email = p.getEmail();
    }
}
