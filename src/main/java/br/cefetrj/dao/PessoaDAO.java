package br.cefetrj.dao;

import java.util.List;

import br.cefetrj.model.Pessoa;

public class PessoaDAO implements GenericDAO<Pessoa> {

    @Override
    public void cadastrar(Pessoa obj) {
        // Implementação para cadastrar uma pessoa
    }

    @Override
    public void atualizar(Pessoa obj) {
        // Implementação para atualizar uma pessoa
    }

    @Override
    public void excluir(Pessoa obj) {
        // Implementação para excluir uma pessoa
    }

    @Override
    public Pessoa consultarPorId(Long id) {
        // Implementação para consultar uma pessoa por ID
        return null;
    }

    @Override
    public List<Pessoa> consultarTodos() {
        // Implementação para consultar todas as pessoas
        return null;
    }

}
