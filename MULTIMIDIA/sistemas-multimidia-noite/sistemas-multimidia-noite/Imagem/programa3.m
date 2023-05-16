## Aluno: Aristofanes Santos de Lira 
## Matricula: 152085386

cla;#comando para limpar janela.
figure(1);#adicionando titulo a janela
a = imread('frutas.jpg');#carregando imagem

subplot(2,2,1);#definindo area de plotagem da imagem
imshow(a);#exibindo imagem na janela 
title('RGB');#definindo titulo da plotagem/imagem

subplot(2,2,2);#definindo area de plotagem da imagem
imshow(a(:,:,1));#exibindo imagem na janela e especificando a matriz(canal de cor).
title('Canal R');#definindo titulo da plotagem/imagem

subplot(2,2,3);#definindo area de plotagem da imagem
imshow(a(:,:,2));#exibindo imagem na janela e especificando a matriz(canal de cor). 
title('Canal G');#definindo titulo da plotagem/imagem

subplot(2,2,4);#definindo area de plotagem da imagem
imshow(a(:,:,3));#exibindo imagem na janela e especificando a matriz(canal de cor). 
title('Canal B'); #definindo titulo da plotagem/imagem


#{
  Após a execução do programa acima, obtive a mesma imagem representada 4 vezes: uma com todas
  as cores, uma com apenas o canal de cor R, uma com apenas o canal de cor G e uma com apenas
  o canal de cor B.
#}