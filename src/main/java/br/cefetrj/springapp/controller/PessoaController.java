package br.cefetrj.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cefetrj.springapp.controller.dto.input.PessoaDtoInput;
import br.cefetrj.springapp.controller.dto.output.PessoaDtoOutput;
import br.cefetrj.springapp.model.Pessoa;
import br.cefetrj.springapp.service.PessoaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<Page<PessoaDtoOutput>> getPessoas(Pageable pageable) {
        return ResponseEntity.ok(service.listarTodos(pageable).map(PessoaDtoOutput::new));
    }

    @PostMapping
    public ResponseEntity<PessoaDtoOutput> cadastrar(@RequestBody PessoaDtoInput pessoaDtoInput) {
        this.service.cadastrar(pessoaDtoInput.build());
        return ResponseEntity.ok(new PessoaDtoOutput(pessoaDtoInput.build()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDtoOutput> editar(@PathVariable Long id,
            @RequestBody PessoaDtoInput pessoaDtoInput) throws Exception {
        if (!pessoaDtoInput.getId().equals(id)) {
            throw new Exception("Erro com o id");
        }
        this.service.atualizar(pessoaDtoInput.build());
        return ResponseEntity.ok(new PessoaDtoOutput(pessoaDtoInput.build()));
    }
}