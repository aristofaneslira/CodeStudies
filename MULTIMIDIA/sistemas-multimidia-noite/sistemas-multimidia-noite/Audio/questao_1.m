## Aluno: Aristofanes Santos de Lira 
## Matricula: 152085386


f = 1000; #frequencia de 1000hz
fa = 2000;#frequencia de amostragem de 10000hz
t = 0:(1/fa):2;#amostras de tempo de 0 a 2 segundos, com espaços de 1/fa.
A = 5;# amplitude utilizada, 5 decibéis
y = A * sin(2*pi*f*t);#funcao que descreve um senoide
sound(y,fa);#funcao para reproduzir o som gerado.
subplot(2,1,1);
plot(t,y);#plotando grafico em relação a tempo
title("NO TEMPO");
subplot(2,1,2);
plot(y,f);#plotando grafico em relação a frequencia
title("NA FREQUENCIA");
audiowrite("audio-q1.wav",y,fa);#função para criar arquivo wave do som gerado.