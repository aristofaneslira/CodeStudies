<!DOCTYPE html>
<?php
header("Content-type: text/html;charset=utf-8");
include_once 'conecta.php';

    $nome = utf8_decode($_POST['nome']) ;
    $cpf  = $_POST['cpf'];
    $id  = $_GET['id'];
    
    echo("Id = $id");
        $sql = "UPDATE tbl_nomes
				SET nome='$nome',cpf='$cpf'
				WHERE id_nome='$id';";
        
        $query = mysqli_query($conexao,$sql);
        
        if($query):
           echo "<script> alert('Registro Editado com Sucesso!'); </script>";
        
        else:
            echo "<script> alert('Erro ao Registrar!'); </script>";
        endif;
        
        
?>

<script src="../js/jquery-1.8.3.min.js"></script>
    <script>
            document.location='../editar.php';
    </script>