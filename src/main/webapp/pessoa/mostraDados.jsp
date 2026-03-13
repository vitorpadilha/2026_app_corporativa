<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    Cadastrado com sucesso!
    
    Nome: <%= request.getAttribute("nome") %>
    <br>
    Idade: <%= request.getAttribute("idade") %>
</body>
</html>