package br.cefetrj.controller;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");
        Long idadeMais10 = Long.parseLong(idade) + 10;
        request.setAttribute("nome", nome);
        request.setAttribute("idade", idadeMais10);
        request.getRequestDispatcher("/pessoa/mostraDados.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");
        Pessoa p1 = new Pessoa(null, nome, Long.parseLong(idade));
        PessoaDAO dao = new PessoaDAO();
        dao.cadastrar(p1);
        request.getRequestDispatcher("/pessoa/mostraDados.jsp").forward(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");
        response.getWriter().append("Chamada via DELETE - Nome: ")
                .append(nome).append(", Idade: ").append(idade);
    }
}