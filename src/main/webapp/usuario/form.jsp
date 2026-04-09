<%@ page import="br.cefetrj.model.Usuario" %>
<%@ page import="br.cefetrj.model.PerfilUsuario" %>
<%@ page import="br.cefetrj.model.Departamento" %>
<%@ page import="java.util.List" %>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    if (usuario == null) {
        usuario = new Usuario(null, "", "", false);
    }
    List<PerfilUsuario> perfisUsuario = (List<PerfilUsuario>) request.getAttribute("perfisUsuario");
    List<Departamento> departamentos = (List<Departamento>) request.getAttribute("departamentos");
%>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Formulário</title>
</head>
<body>
    <form action="/app-corporativa/usuario" method="post">
        <input type="hidden" name="id" 
               value="<%= usuario.getId() != null ? usuario.getId() : "" %>">

        <label for="email">Email:</label>
        <input type="text" id="email" name="email" 
               value="<%= usuario.getEmail() != null ? usuario.getEmail() : "" %>">
        <br>

        <label for="senha">Senha:</label>
        <input type="text" id="senha" name="senha" value="<%= usuario.getSenha() != null ? usuario.getSenha() : "" %>">
        <br>
        <label for="ativo">Perfis de Usuário:</label>

        <% for (PerfilUsuario perfil : perfisUsuario) { %>
            <input type="checkbox" id="perfil_<%= perfil.getId() %>" name="perfil" value="<%= perfil.getId() %>" <%= (usuario.getPerfis() != null && usuario.getPerfis().contains(perfil)) ? "checked" : "" %>>
            <label for="perfil_<%= perfil.getId() %>">&nbsp;<%= perfil.getNome() %></label>
        <% } %>
 <br>
        <label for="departamento">Departamento:</label>
        <select id="departamento" name="departamento">
            <option value="">Selecione um departamento</option>
            <% for (Departamento dept : departamentos) { %>
                <option value="<%= dept.getId() %>" <%= (usuario.getDepartamento() != null && usuario.getDepartamento().getId().equals(dept.getId())) ? "selected" : "" %>><%= dept.getNome() %></option>
            <% } %>
        </select>
        <br>

        <input type="submit" value="Enviar">
    </form>
</body>
</html>