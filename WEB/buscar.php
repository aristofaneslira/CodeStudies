<!doctype html>
<html>
    <head>
    <title>Buscar</title>
    <meta charset="UTF-8" />
    <link type="text/css" rel="stylesheet" href="css/css.css" />
    </head>
    <body class="container3">
    <a  href="index.php">Cadastrar</a> | <a href="listar.php">Listar</a> | <a href="buscar.php">Pesquisar</a> | <a href="editar.php">Editar</a>
    <form class="meio" action="buscar.php" method="POST" >
    Insira o CPF:
    <input type="text" name="buscar" id="busca" />
     <input type="submit" name="button"  value="Buscar" />
     <input type="hidden" name="acao" id="hiddenField" value="buscar" />
     
    </form>

    <?php
    
    include_once 'functions/conecta.php';
        if(isset($_POST['acao']) && $_POST['acao'] == 'buscar')
        {
            $pesquisa = $_POST['buscar'];

            $sql =mysqli_query($conexao,"SELECT * FROM tbl_nomes WHERE id_nome like'%$pesquisa%' or cpf like'%$pesquisa%' ");
               
            while ($resultado = mysqli_fetch_assoc($sql)){
            $id = $resultado['id_nome'];    
            $nome = $resultado['nome'];
            $cpf = $resultado['cpf'];
        ?>

    <table border style="width: 500px">
            
            <thead>
                <tr>
                    <td style="width: 50px; background: #ccc">Id</td>
                    <td style="width: 300px; background: #ccc">Nome</td>
                    <td style="width: 150px; background: #ccc">CPF</td>
                    
                </tr>
            </thead>
            
            <tbody>
                <tr>
                    <td style="width: 50px"><?php echo $id ;?></td>
                    <td style="width: 300px"><?php echo utf8_encode($nome) ;?></td>
                    <td style="width: 150px"><?php echo $cpf ;?></td>
                </tr>
            </tbody>
        </table>
        <?php
            }
          } 
          
        ?>
    </body>

     <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/jquery.maskedinput.min.js"></script>
    <script>
        $(function() {
            $.mask.definitions['~'] = "[+-]";
            $("#busca").mask("999.999.999-99");
                    $("#pct").mask("99%");

            $("input").blur(function() {
                $("#info").html("Unmasked value: " + $(this).mask());
            }).dblclick(function() {
                $(this).unmask();
            });
        });
    
    </script>
    
</html>