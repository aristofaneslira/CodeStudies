
<?php
    function listar(){
        include_once './conecta.php';

        $sql = "SELECT * FROM cadastro ORDER BY cadastro";

        $query = mysqli_query($conn, $sql);

        $nomes = array();      
        if(mysqli_num_rows($query)>0){
            while($dados = mysqli_fetch_object($query)){
                $nomes[] = $dados;
            }
            return $nomes;
        }
    }
?>

