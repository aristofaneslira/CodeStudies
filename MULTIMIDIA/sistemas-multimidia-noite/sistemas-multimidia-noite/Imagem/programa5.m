## Aluno: Aristofanes Santos de Lira 
## Matricula: 152085386

pkg load image#carregando pacote de image
cla;#comando para limpar janela.
a = imread('rgb.png');#carregando imagem

c = rgb2ycbcr(a);#aplicando conversao de cores, de rgb para ycbcr
subplot(2,2,1);#definindo area de plotagem da imagem
imshow(c);#exibindo imagem na janela
title('YCbCr');#definindo titulo da plotagem/imagem

subplot(2,2,2);#definindo area de plotagem da imagem
y = c;
y(:,:,2)=0;
y(:,:,3)=0;
imshow(y);#exibindo imagem na janela a matriz(canal de cor).
title('Y');#definindo titulo da plotagem/imagem

subplot(2,2,3);#definindo area de plotagem da imagem
cb = c;
cb(:,:,1)=0;
cb(:,:,3)=0;
imshow(cb);#exibindo imagem na janela e especificando a matriz(canal de cor). 
title('Cb');#definindo titulo da plotagem/imagem

subplot(2,2,4);#definindo area de plotagem da imagem
cr = c;
cr(:,:,1)=0;
cr(:,:,2)=0;
imshow(cr);#exibindo imagem na janela e especificando a matriz(canal de cor). 
title('Cr');#definindo titulo da plotagem/imagem


#{
  O programa acima carrega uma imagem rgb e faz a conversão para YCbCr,logo após mostrar as
  três componentes de cores da imagem, Y, Cb e Cr.
#}