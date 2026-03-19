package br.cefetrj.controller.pessoa;

import java.io.IOException;

import br.cefetrj.dao.PessoaDAO;
import br.cefetrj.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/remover_pessoa")
public class RemoverPessoaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
}
