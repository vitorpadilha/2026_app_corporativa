<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.model.Pessoa" %>

<%
    List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");
%>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Lista de Pessoas</title>
</head>
<body>

<h2>Lista de Pessoas</h2>

<a href="/aula2/pessoa/form.jsp">Nova Pessoa</a>

<br><br>

<table border="1">
    <tr>
        <th>Nome</th>
        <th>Idade</th>
        <th>Ações</th>
    </tr>

    <%
        if (pessoas != null && !pessoas.isEmpty()) {
            for (Pessoa p : pessoas) {
    %>
    <tr>
        <td><%= p.getNome() %></td>
        <td><%= p.getIdade() %></td>
        <td>
            <a href="/aula2/carrega_pessoa?id=<%= p.getId() %>">Editar</a>
            |
            <a href="/aula2/remover_pessoa?id=<%= p.getId() %>" onclick="return confirm('Deseja remover?');">Remover</a>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="3">Nenhuma pessoa encontrada</td>
    </tr>
    <%
        }
    %>

</table>

</body>
</html>