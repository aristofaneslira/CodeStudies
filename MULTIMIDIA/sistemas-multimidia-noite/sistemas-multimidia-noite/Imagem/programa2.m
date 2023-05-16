## Aluno: Aristofanes Santos de Lira 
## Matricula: 152085386

pkg load image#carregando pacote de image
subplot(2,2,1);#funcao para fazer uma subplotagem, com essa funcao � possivel plotar varios grafico e imagens na mesma janela
a=imread('lenna.jpg');#funcao para carregar imagem
imshow(a);#funcao para mostar imagem carregada
title('RGB');#definindo titulo do grafico/imagem plotada

subplot(2,2,3);#funcao para fazer uma subplotagem, com essa funcao � possivel plotar varios grafico e imagens na mesma janela
c=rgb2gray(a);#funcao para aplicar conversao de cores, de rgb para gray
imshow(c);#funcao para mostar imagem carregada
title('GRAY');#definindo titulo do grafico/imagem plotada

subplot(2,2,4);#funcao para fazer uma subplotagem, com essa funcao � possivel plotar varios grafico e imagens na mesma janela
d=im2bw(a,0.35);#funcao para aplicar conversao de cores para preto e branco
imshow(d);#funcao para mostar imagem carregada
title('BW');#definindo titulo do grafico/imagem plotada

#{
  Ap�s a execu��o obtive do programa acima, a mesma imagem ser� mostrada com 
  3 tipos de apresenta��o, uma colorida, uma com filtro gray e uma preto e branco.
#}