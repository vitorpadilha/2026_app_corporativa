package br.cefetrj.controller.pessoa;

import java.io.IOException;

import br.cefetrj.dao.PessoaDAO;
import br.cefetrj.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//http://localhost:8080/{contexto}/pessoa
//http://localhost:8080/aula2/pessoa
@WebServlet("/pessoa")
public class PessoaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            doPut(request, response);
            return;
        }
        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");
        Pessoa p1 = new Pessoa(null, nome, Long.parseLong(idade));
        PessoaDAO dao = new PessoaDAO();
        try {
            dao.cadastrar(p1);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/pessoa/mostraDados.jsp").forward(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PessoaDAO dao = new PessoaDAO();
        String id = request.getParameter("id");
        try {
            Pessoa pessoa = dao.consultarPorId(Long.parseLong(id));
            dao.excluir(pessoa);
        } catch (Exception e) {
            System.out.println("Erro ao excluir pessoa: " + e.getMessage());
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/pessoa/msg_deletar.jsp").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");
        Pessoa p1 = new Pessoa(null, nome, Long.parseLong(idade));
        PessoaDAO dao = new PessoaDAO();
        try {
            dao.atualizar(p1);
        } catch (Exception e) {
            System.out.println("Erro ao alterar pessoa: " + e.getMessage());
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/pessoa/mostraDados.jsp").forward(request, response);

    }
}