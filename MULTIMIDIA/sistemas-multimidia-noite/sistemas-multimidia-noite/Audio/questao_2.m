## Aluno: Aristofanes Santos de Lira 
## Matricula: 152085386


[y,fa] = audioread("audio.wav");#função para carregar arquivo de audio

sound(y,fa);# reproduzindo som sem o ruido

ruido1 = y + 0.01 * randn(length(y),1);
sound(ruido1,fa);# reproduzindo som com o primeiro nivel de ruido
audiowrite("audio-q2-ruido1.wav",ruido1,fa);#salvando arquivo com primeiro nivel de ruido.

ruido2 = y + 0.1 * randn(length(y),1);
sound(ruido2,fa);# reproduzindo som com o segundo nivel de ruido
audiowrite("audio-q2-ruido2.wav",ruido2,fa);#salvando arquivo com segundo nivel de ruido.

ruido3 = y + 1 * randn(length(y),1);
sound(ruido3,fa);# reproduzindo som com o terceiro nivel de ruido
audiowrite("audio-q2-ruido3.wav",ruido3,fa);#salvando arquivo com terceiro nivel de ruido.

#{
  Após a execução do programa acima obtemos 4 diferentes arquivos de audio: o original,
  um com um leve ruido, um com um ruido maior e o ultimo com ruido bem alto.
  
#}