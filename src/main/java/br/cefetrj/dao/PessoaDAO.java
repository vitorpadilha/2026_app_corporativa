package br.cefetrj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.cefetrj.dao.utils.ConnectionFactory;
import br.cefetrj.model.Pessoa;

public class PessoaDAO implements GenericDAO<Pessoa> {

    @Override
    public void cadastrar(Pessoa obj) {
        String sql = "INSERT INTO pessoa (nome, idade) VALUES (?, ?)";
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        try {
            preparedStatement.setString(1, obj.getNome());
            preparedStatement.setLong(2, obj.getIdade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
