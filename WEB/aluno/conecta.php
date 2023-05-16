<?php
    
    $server = "localhost";
    $user = "root";
    $password = "root";
    $database ="aluno";
    
    $conn = mysqli_connect($server, $user, $password, $database);
    
    if(!$conn){
        die ("falha na conexão com a  database". mysqli_connect_errno());
    }else{
        //echo "Conexão realizada";
    }
?>
