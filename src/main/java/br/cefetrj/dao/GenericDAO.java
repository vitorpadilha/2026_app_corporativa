package br.cefetrj.dao;

import java.sql.SQLException;
import java.util.List;

import br.cefetrj.model.EntidadeGenerica;

public interface GenericDAO<T extends EntidadeGenerica> {

    void cadastrar(T obj) throws SQLException;

    void atualizar(T obj) throws SQLException;

    void excluir(T obj) throws SQLException;

    T consultarPorId(Long id) throws SQLException;

    List<T> consultarTodos() throws SQLException;
}