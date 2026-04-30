package br.cefetrj.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.cefetrj.springapp.model.Pessoa;
import br.cefetrj.springapp.repository.PessoaRepository;

@Service
public class PessoaService implements GenericService<Pessoa> {
    @Autowired
    private PessoaRepository repository;

    public void cadastrar(Pessoa entidade) {
        this.repository.save(entidade);
    }

    public void atualizar(Pessoa entidade) {
        this.repository.save(entidade);
    }

    public Page<Pessoa> listarTodos(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Pessoa getById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public void remover(Pessoa entidade) {
        this.repository.delete(entidade);
    }

    public Pessoa pegaPorCPF(Long cpf) {
        return this.repository.findByCpf(cpf).orElse(null);
    }

}