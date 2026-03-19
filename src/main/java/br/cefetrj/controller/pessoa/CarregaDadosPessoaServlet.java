package br.cefetrj.controller.pessoa;

import java.io.IOException;

import br.cefetrj.dao.PessoaDAO;
import br.cefetrj.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/carrega_pessoa")
public class CarregaDadosPessoaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        PessoaDAO dao = new PessoaDAO();
        try {
            Pessoa pessoa = dao.consultarPorId(Long.parseLong(id));
            request.setAttribute("pessoa", pessoa);
        } catch (Exception e) {
            System.out.println("Erro ao carregar pessoa: " + e.getMessage());
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/pessoa/form.jsp").forward(request, response);
    }

}
