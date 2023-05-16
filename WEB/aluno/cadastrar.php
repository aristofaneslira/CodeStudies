<?php

    include_once './conecta.php';
    
    $nome = $_POST["nome"];
    $matricula = $_POST["matricula"];
    $turma = $_POST["turma"];
    $turno = $_POST["turno"];
    $curso = $_POST["curso"];
    
    $sql ="INSERT INTO aluno (nome,matricula,turma,turno,curso) VALUES ('$nome','$matricula','$turma','$turno','$curso')";
    
    $query = mysqli_query($conn, $sql);
    
    if($query){
        echo "Dados Salvo com Sucesso";
    }else{
        echo "Erro ao salvar dados";
    }

