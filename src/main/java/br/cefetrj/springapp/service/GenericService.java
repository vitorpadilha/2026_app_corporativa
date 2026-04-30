package br.cefetrj.springapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.cefetrj.springapp.model.EntidadeGenerica;
import br.cefetrj.springapp.repository.GenericRepository;

public interface GenericService<T extends EntidadeGenerica> {
    public void cadastrar(T entidade);

    public void atualizar(T entidade);

    public Page<T> listarTodos(Pageable pageable);

    public T getById(Long id);

    public void remover(T entidade);
}
