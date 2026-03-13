<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body><%
    String nome = request.getParameter("nome");
    String dataNasc = request.getParameter("dataNasc");
%>
    <p>Nome: <%= nome %></p>
    <p>Data de Nascimento: <%= dataNasc %></p>
</body>
</html>