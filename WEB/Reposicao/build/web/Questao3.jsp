<%-- 
    Document   : Questao3
    Created on : 24/02/2017, 12:10:21
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questao3</title>
    </head>
    <body>
        <h1 style="text-align: center">Notas</h1>
        <form style="text-align: center" action="Questao3" method="post">
            Nome: <input type="text" name="nome">
            <br>
            Nota1: <input type="number" name="nota1">
            Nota2: <input type="number" name="nota2">
            Nota3: <input type="number" name="nota3">
            <br>
            
            <input type="submit" value="Verificar">
            
        </form>
    </body>
</html>
