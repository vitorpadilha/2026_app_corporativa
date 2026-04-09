package br.cefetrj.servlet;

import java.io.IOException;

import br.cefetrj.dao.UsuarioDAO;
import br.cefetrj.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuario")
public class AlteraUsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            doPut(request, response);
            return;
        }
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario p1 = new Usuario(null, email, senha, false);
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.salvar(p1);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/usuario/mostraDados.jsp").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario p1 = new Usuario(Long.parseLong(id), email, senha, false);
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.atualizar(p1);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/usuario/mostraDados.jsp").forward(request, response);
    }
}