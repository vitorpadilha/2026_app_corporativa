package br.cefetrj.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import br.cefetrj.dao.DepartamentoDAO;
import br.cefetrj.dao.PerfilUsuarioDAO;
import br.cefetrj.dao.UsuarioDAO;
import br.cefetrj.model.Departamento;
import br.cefetrj.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String[] perfis = request.getParameterValues("perfil");
        String departamentoId = request.getParameter("departamento");
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        PerfilUsuarioDAO perfilUsuarioDAO = new PerfilUsuarioDAO();
        boolean erro = false;
        Set<String> erros = new HashSet<>();
        Usuario usuarioErro = new Usuario(id != null ? Long.valueOf(id) : null, email, senha, false, null, null);
        if (departamentoId == null || departamentoId.isEmpty()) {
            erro = true;
            erros.add("Departamento é obrigatório.");
        } else {
            usuarioErro.setDepartamento(departamentoDAO.buscarPorId(Long.valueOf(departamentoId)));
        }
        if (perfis == null || perfis.length == 0) {
            erro = true;

            erros.add("Selecione ao menos 1 perfil");
        } else {
            usuarioErro.setPerfis(new ArrayList<>());
            for (int i = 0; i < perfis.length; i++) {
                String perfilId = perfis[i];
                usuarioErro.getPerfis().add(perfilUsuarioDAO.buscarPorId(Long.valueOf(perfilId)));
            }
        }
        request.setAttribute("usuarioErro", usuarioErro);
        if (id != null && !id.isEmpty()) {
            doPut(request, response);
            return;
        }

        if (!erro) {

            Usuario p1 = new Usuario(null, email, senha, false, usuarioErro.getPerfis(), usuarioErro.getDepartamento());
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.salvar(p1);
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
                throw new RuntimeException(e);
            }
            request.getRequestDispatcher("/usuario/mostraDados.jsp").forward(request, response);
        } else {
            request.setAttribute("usuario", usuarioErro);
            request.getRequestDispatcher("/usuario/form.jsp").forward(request, response);
        }

    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuarioErro = (Usuario) request.getAttribute("usuarioErro");

        Usuario p1 = new Usuario(Long.parseLong(id), email, senha, false, usuarioErro.getPerfis(),
                usuarioErro.getDepartamento());
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.atualizar(p1);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/usuario/mostraDados.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Entrou no doGet do UsuarioServlet");
        String id = request.getParameter("id");
        String acao = request.getParameter("acao");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PerfilUsuarioDAO perfilUsuarioDAO = new PerfilUsuarioDAO();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        if (id == null || id.isEmpty()) {
            if (acao != null && acao.equals("listar")) {
                request.setAttribute("usuarios", usuarioDAO.listarTodos());
                response.sendRedirect("/app-corporativa/usuario/lista");
                return;
            } else {
                request.setAttribute("departamentos", departamentoDAO.listarTodos());
                request.setAttribute("perfisUsuario", perfilUsuarioDAO.listarTodos());
                request.getRequestDispatcher("/usuario/form.jsp").forward(request, response);
                return;
            }
        }
        try {

            Usuario usuario = usuarioDAO.buscarPorId(Long.valueOf(id));
            request.setAttribute("usuario", usuario);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
            throw new RuntimeException(e);
        }

        if (acao == null || acao.isEmpty()) {
            request.getRequestDispatcher("/usuario/mostraDados.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/usuario/form.jsp").forward(request, response);
    }
}