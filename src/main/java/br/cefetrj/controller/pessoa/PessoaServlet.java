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

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");
        PessoaDAO dao = new PessoaDAO();
        try {
            Pessoa p1 = dao.consultarPorId(Long.parseLong(id));
            p1.setNome(nome);
            p1.setIdade(Long.parseLong(idade));
            dao.atualizar(p1);
        } catch (Exception e) {
            System.out.println("Erro ao alterar pessoa: " + e.getMessage());
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/pessoa/mostraDados.jsp").forward(request, response);

    }
}