package br.cefetrj.springapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class EntidadeGenerica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
