<!DOCTYPE html>
<?php
header("Content-type: text/html;charset=utf-8");
include_once 'conecta.php';
    $nome = utf8_decode($_POST['nome']) ;
    $cpf  = $_POST['cpf'];

        $sql = "insert into tbl_nomes (nome, cpf) values('$nome', '$cpf')";
        $query = mysqli_query($conexao, $sql);
        
        if($query):
           echo "<script> alert('Registro Salvo com Sucesso!'); </script>";
        
        else:
            echo "<script> alert('Erro ao Registrar!'); </script>";
        endif; 
?>
<script src="../js/jquery-1.8.3.min.js"></script>
    <script>
            document.location='../index.php';
    </script>