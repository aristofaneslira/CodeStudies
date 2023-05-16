<!DOCTYPE html>
<?php
    include_once 'functions/conecta.php';
    include_once 'functions/function_listar.php';
?>
<html>
    <head>
        <title>Listar</title>
        <meta charset="utf-8" />
        <link type="text/css" rel="stylesheet" href="css/css.css" />
    </head>
    <body class="container">
        <div class="meio">
            <a  href="index.php">Cadastrar</a> | <a href="listar.php">Listar</a> | <a href="buscar.php">Pesquisar</a> | <a href="editar.php">Editar</a>
        </div>
        
        <?php
            
            $dados = listar();
            $d = new ArrayIterator($dados);
        ?>
        
        <table border>
            <thead>
                <tr>
                    <td style="background: #ccc">Id</td>
                    <td style="background: #ccc">Nome</td>
                    <td style="background: #ccc">CPF</td>
                    <td style="background: #ccc">Opções</td>
                </tr>
            </thead>
            
            <?php while ($d->valid()){?>
            
            <tbody>
                <tr>
                    <td><?php echo $d->current()->id_nome ?></td>
                    <td><?php echo utf8_encode($d->current()->nome) ?></td>
                    <td><?php echo $d->current()->cpf ?></td>
                    <td><a href="functions/form_edit.php?id=<?php echo $d->current()->id_nome; ?>">Editar</a></td>
                </tr>
                <?php $d ->next();} ?>
            </tbody>
           
        </table>
    </body>
</html>