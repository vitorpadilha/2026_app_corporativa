<%@ page import="br.cefetrj.model.Usuario" %>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    if (usuario == null) {
        usuario = new Usuario(null, "", "", false);
    }
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
        <input type="text" id="senha" name="senha" 
               value="<%= usuario.getSenha() != null ? usuario.getSenha() : "" %>">
        <br>

        <input type="submit" value="Enviar">
    </form>
</body>
</html>