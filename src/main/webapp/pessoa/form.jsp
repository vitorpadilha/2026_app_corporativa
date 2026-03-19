<%@ page import="br.cefetrj.model.Pessoa" %>
<%
    Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
    if (pessoa == null) {
        pessoa = new Pessoa(null, "", null);
    }
%>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Formulário</title>
</head>
<body>
    <form action="/aula2/pessoa" method="post">
        <input type="hidden" name="id" 
               value="<%= pessoa.getId() != null ? pessoa.getId() : "" %>">

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" 
               value="<%= pessoa.getNome() != null ? pessoa.getNome() : "" %>">
        <br>

        <label for="idade">Idade:</label>
        <input type="number" id="idade" name="idade" 
               value="<%= pessoa.getIdade() != null ? pessoa.getIdade() : "" %>">
        <br>

        <input type="submit" value="Enviar">
    </form>
</body>
</html>