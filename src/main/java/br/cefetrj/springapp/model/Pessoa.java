package br.cefetrj.springapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoas")
public class Pessoa extends EntidadeGenerica {
    private String nome;
    private String email;
    private Long cpf;
    private LocalDateTime dataNascimento;
}
