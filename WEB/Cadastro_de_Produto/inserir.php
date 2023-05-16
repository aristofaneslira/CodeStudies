<?php

    include_once './conecta.php';
    
    $nome = $_POST["nome"];
    $preco = $_POST["preco"];
    $quantidade = $_POST["quantidade"];
    
    $sql ="INSERT INTO cadastro (nome,preco,quantidade) VALUES ('$nome','$preco','$quantidade')";
    
    $query = mysqli_query($conn, $sql);
    
    if($query){
        echo "Dados Salvo com Sucesso";
    }else{
        echo "Erro ao salvar dados";
    }



