<?php

    include_once 'conecta.php';
    include_once 'function_listar.php';

    if(isset($_GET['id']))
    {
        $id = $_GET['id'];

        
        echo("Existe o id $id");
    }

?>

<!DOCTYPE html>
<html>
    <head>
        <title>Banco de Dados</title>
        <meta charset="UTF-8" />
        <link type="text/css" rel="stylesheet" href="css/css.css" />
    </head>
    <body class="container2">
        
        <section style="text-align: center">
            <div class="meio">
                <a  href="../index.php">Cadastrar</a> | <a href="../listar.php">Listar</a> | <a href="../buscar.php">Pesquisar</a> | <a href="../editar.php">Editar</a>
            </div>
            <form action="update.php?id=<?php echo $id ?>" method="post">
                <fieldset>
                    <legend>Formulário de Cadastro</legend>
                    
                    <?php
     
                        $sql =mysqli_query($conexao,"SELECT * FROM tbl_nomes WHERE id_nome = $id");

                        while ($resultado = mysqli_fetch_assoc($sql)){
                        $id = $resultado['id_nome'];    
                        $nome = $resultado['nome'];
                        $cpf = $resultado['cpf'];
                    ?>
                   
                    <label>Nome</label>
                    <input type="text" name="nome" value="<?php echo utf8_encode($nome) ;?>"/>
                    
                    
                    <label>CPF</label>
                    <input id="cpf" tabindex="1" type="text" name="cpf"  value="<?php echo ($cpf) ;?>"/>
                    
                    <input type="submit" name="cadastra" value="Salvar" />
                    
                   <?php
                        }
                    ?>

                    <br />
                    <span style="margin-right: 100px; margin-left: -70px; color: #939392; font-size: 12px">Nome Completo</span>
                    
                    <span style="color: #939392; font-size: 12px">Só Números</span>
                    
                </fieldset>
            </form>
        </section>
    </body>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/jquery.maskedinput.min.js"></script>
    <script>
        $(function() {
            $.mask.definitions['~'] = "[+-]";
            $("#cpf").mask("999.999.999-99");
                    $("#pct").mask("99%");

            $("input").blur(function() {
                $("#info").html("Unmasked value: " + $(this).mask());
            }).dblclick(function() {
                $(this).unmask();
            });
        });
    
    </script>
</html>