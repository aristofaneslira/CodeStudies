<!DOCTYPE html>
<?php

    $servidor="localhost";
    $username="root";
    $password="";
    $banco="banco";

   // $conecta_servidor=  mysql_connect($servidor, $username, $password);
   // $conecta_banco= mysql_select_db($banco);
    
    $conexao = mysqli_connect($servidor, $username, $password, $banco);

   if (mysqli_connect_errno($conexao)) {
     
        echo "Não foi possível conectar ao banco de {$bdBanco}";
        die();
    }
