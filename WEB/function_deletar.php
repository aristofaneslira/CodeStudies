<?php

function deletar($id)
{
   // $sql = "DELETE FROM tbl_nomes WHERE id_nome = '$id'";
   // $query = mysqli_query($sql);
    
    
    $servidor="localhost";
    $username="root";
    $password="esfera";
    $banco="banco";

     $conexao = mysqli_connect($servidor, $username, $password, $banco);
    
    $sql = "DELETE FROM tbl_nomes WHERE id_nome = '$id'";
    $query = mysqli_query($conexao,$sql);
    
    if($query)
    {
        echo "<script> alert('Registro Deletado com Sucesso!'); </script>";  
        ?>

        <script src="../js/jquery-1.8.3.min.js"></script>
        <script>
                document.location='listar.php';
        </script>

        <?php 
    }
    else{
        echo "<script> alert('Erro ao Deletar!'); </script>";
        }
}
?>
