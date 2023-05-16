<%-- 
    Document   : Questao1
    Created on : 24/02/2017, 11:15:48
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questao1</title>
    </head>
    <body>
        <form style="text-align: center" action="Questao1" method="post" title="Formulario de Cadastro de Aluno">
            Matricula:<br>
            <input type="text" name="matricula"><br>
            Nome do aluno: <br>
            <input type="text" name="nome"> <br>
            Sexo: <br>
            <input type="radio" name="sexo" value="Feminino"> Feminino 
            <input type="radio" name="sexo" value="Masculino"> Masculino
            <br>
            Estado Civil:<br>
            <select name="estado">
                <option value="Solteiro">Soleiro</option>
                <option value="Casado">Casado</option>
                <option value="Viuvo">Viuvo</option>
                <option value="Divorciado">Divorciado</option>
            </select><br>
            Email:<br>
            <input type="email" name="email">
            <br>
            CPF:<br>
            <input type="text" name="cpf">
            <br>
            RG:<br>
            <input type="text" name="rg">
            <br>
            Data de Nascimento:<br>
            <input type="text" name="data">
            <br>
            Nome da Mae:<br>
            <input type="text" name="nomeMae">
            <br>
            Nome do Pai:<br>
            <input type="text" name="nomePai">
            <br>
            Endereço:<br>
            <input type="text" name="endereco">
            <br>
            Telefone:<br>
            <input type="tel" name="tele">
            <br>

            Cursos:<br>
            <input type="checkbox" name="curso" value="Web Design">Web Design
            <input type="checkbox" name="curso" value="Manutencao de micro">Manutencao de micro
            <input type="checkbox" name="curso" value="Auto CAD">Auto CAD
            <input type="checkbox" name="curso" value="Editor Grafico" >Editor Gráfico
            <br>
            <input type="submit" value="Enviar">
        </form>

    </body>
</html>
