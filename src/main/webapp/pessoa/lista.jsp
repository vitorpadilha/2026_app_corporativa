<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Usuario" %>

<%
    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
%>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Lista de Pessoas</title>
</head>
<body>

<h2>Lista de Pessoas</h2>

<a href="/app-coorporativa/usuario/form.jsp">Novo    Usuário</a>

<br><br>

<table border="1">
    <tr>
        <th>Email</th>
        <th>Senha</th>
        <th>Ações</th>
    </tr>

    <%
        if (usuarios != null && !usuarios.isEmpty()) {
            for (Usuario u : usuarios) {
    %>
    <tr>
        <td><%= u.getEmail() %></td>
        <td><%= u.getSenha() %></td>
        <td>
            <a href="/aula2/carrega_pessoa?id=<%= u.getId() %>">Editar</a>
            |
            <a href="/aula2/remover_pessoa?id=<%= u.getId() %>" onclick="return confirm('Deseja remover?');">Remover</a>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="3">Nenhum usuário encontrado</td>
    </tr>
    <%
        }
    %>

</table>

</body>
</html>