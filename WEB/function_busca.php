<?php
function pegarPeloId ($id)
{
    $id = $_GET['id'];

        $sql = "SELECT * FROM tbl_nomes WHERE id='$id'";
        $query = mysqli_query($conexao,$sql);;
        
    print_r($query);
}