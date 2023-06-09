## Aluno: Aristofanes Santos de Lira 
## Matricula: 152085386

p =[
1 1
1 -1
-1 -1
-1 1];#definindo pontos do poligono

subplot(2,2,1);
fill (p(:,1), p(:,2), "r");#desenhando poligono e preenchendo com a cor vermelha
axis ([-2.5 8.5, -2.5 8.5])
axis equal
title("ORIGINAL");

#translacao com x=3 y=1
t = p;
t(:,1)+=3;
t(:,2)+=1;

subplot(2,2,2);
fill (t(:,1), t(:,2), "r");#desenhando poligono e preenchendo com a cor vermelha
axis ([-2.5 8.5, -2.5 8.5])
axis equal
title("TRANSLACAO");

#rotacao de 45� (pi/4)
r = p;
r(:,1)+=1;
r(:,2)+=1;
rotacao = [
cos(45) sin(45)
-sin(45) cos(45)
];
r *= rotacao;
subplot(2,2,3);
fill (r(:,1), r(:,2), "r");#desenhando poligono e preenchendo com a cor vermelha
axis ([-2.5 8.5, -2.5 8.5])
axis equal
title("ROTACAO");

#escala de sx=2 sy=3
s = p;
s(:,1)+=1;
s(:,2)+=1;
escala = [
3 0
0 2
];
s *= escala;
subplot(2,2,4);
fill (s(:,1), s(:,2), "r");#desenhando poligono e preenchendo com a cor vermelha
axis ([-2.5 8.5, -2.5 8.5])
axis equal
title("ESCALA");

