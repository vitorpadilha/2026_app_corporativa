package br.cefetrj.dao;

import java.sql.Connection;
import java.util.List;

import br.cefetrj.model.EntidadeGenerica;

public interface GenericDAO<T extends EntidadeGenerica> {

    void cadastrar(T obj);

    void atualizar(T obj);

    void excluir(T obj);

    T consultarPorId(Long id);

    List<T> consultarTodos();
}