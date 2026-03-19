<!DOCTYPE html>
<%@ page import="br.cefetrj.model.Pessoa" %>
    <%
        Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
         if (pessoa == null) {
             pessoa = new Pessoa(null, "", null); 
        }
    }
    %>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="/aula2/pessoa" method="post">
        <input type="hidden" name="id" value="<%= pessoa.getId() %>">
        <label for="nome">Nome 2:</label>
        <input type="text" id="nome" name="nome" value="<%= pessoa.getNome() %>">
        <br>
        <label for="idade">Idade:</label>
        <input type="number" id="idade" name="idade">
        <br>
        
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
<!-- 
http://localhost:8080/{contexto}/form.jsp
-->