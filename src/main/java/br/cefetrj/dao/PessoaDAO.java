package br.cefetrj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefetrj.dao.utils.ConnectionFactory;
import br.cefetrj.model.Pessoa;

public class PessoaDAO implements GenericDAO<Pessoa> {

    @Override
    public void cadastrar(Pessoa obj) throws SQLException {
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
    public void atualizar(Pessoa obj) throws SQLException {
        String sql = "UPDATE pessoa SET nome = ?, idade = ? WHERE id = ?";
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        try {
            preparedStatement.setString(1, obj.getNome());
            preparedStatement.setLong(2, obj.getIdade());
            preparedStatement.setLong(3, obj.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(Pessoa obj) throws SQLException {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        try {
            preparedStatement.setLong(1, obj.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pessoa consultarPorId(Long id) throws SQLException {
        // Implementação para consultar uma pessoa por ID
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        try {
            java.sql.ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Pessoa pessoa = new Pessoa(rs.getLong("id"), rs.getString("nome"), rs.getLong("idade"));
                return pessoa;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Pessoa> consultarTodos() throws SQLException {
        // Implementação para consultar todas as pessoas
        String sql = "SELECT * FROM pessoa";
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        try {
            java.sql.ResultSet rs = preparedStatement.executeQuery();
            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(rs.getLong("id"), rs.getString("nome"), rs.getLong("idade"));
                pessoas.add(pessoa);
            }
            return pessoas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
