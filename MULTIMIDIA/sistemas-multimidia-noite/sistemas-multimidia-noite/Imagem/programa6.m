## Aluno: Aristofanes Santos de Lira 
## Matricula: 152085386

#{
  O que acontece � que o formato gif n�o armazena informa��es de cores a fim de economizar
  espa�o, ele utiliza um mapa de cor em vez de passa as informa��es de cores. Sendo assim �
  necessario armazenar esse mapa e depois passar para o visualizador esse mapa para a imagem
  ser visualizada corretamente.
#}

cla;
[gif,mapa] = imread('gato.gif');
imshow(gif,mapa);
title("GIF");

#{
  Perceba que diferente do programa_1, este programa armazena a imagem e um mapa de cores.
  Quando chamamos a funcao imshow passamos esse mapa.
#}
