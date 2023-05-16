## Aluno: Aristofanes Santos de Lira 
## Matricula: 152085386


function [y,fa] = gerarSom (freq,temp)
  fa = 3*max(freq);
  t = 0:1/fa:temp;
  f1 = freq(1);
  f2 = freq(2);
  y = 0; 
  for f = freq
    y += sin(2*pi*f*t);
  endfor
endfunction