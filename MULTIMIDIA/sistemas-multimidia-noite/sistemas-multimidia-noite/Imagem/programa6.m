## Aluno: Aristofanes Santos de Lira 
## Matricula: 152085386

#{
  O que acontece é que o formato gif não armazena informações de cores a fim de economizar
  espaço, ele utiliza um mapa de cor em vez de passa as informações de cores. Sendo assim é
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
