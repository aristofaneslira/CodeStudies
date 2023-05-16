## Aluno: Aristofanes Santos de Lira 
## Matricula: 152085386

pkg load image#carregando pacote de image
cla;#comando para limpar janela.
a = imread('rgb.png');#carregando imagem
imshow(a);
subplot(2,2,1);#definindo area de plotagem da imagem
r = a;
r(:,:,2)=0;#zerando matriz G
r(:,:,3)=0;#zerando matriz B
imshow(r);#exibindo imagem na janela.
title('R');#definindo titulo da plotagem/imagem

subplot(2,2,2);#definindo area de plotagem da imagem
g = a;
g(:,:,1)=0;#zerando matriz R
g(:,:,3)=0;#zerando matriz G
imshow(g);#exibindo imagem na janela.
title('G');#definindo titulo da plotagem/imagem

subplot(2,2,3);#definindo area de plotagem da imagem
b = a;
b(:,:,1)=0;#zerando matriz R
b(:,:,2)=0;#zerando matriz B
imshow(b);#exibindo imagem na janela.
title('B');#definindo titulo da plotagem/imagem

#{
  O programa acima carrega uma imagem e mostrar a imagem separada
  R, G e B.
#}