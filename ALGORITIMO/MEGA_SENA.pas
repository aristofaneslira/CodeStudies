Program MEGA_SENA;
uses crt;
var
pararSorteio: char;
numerosSorteados : array [1..6] of integer;
i, j : integer;

     procedure cabecalho;
     begin

          textcolor(15);

          for i := 1 to 79 do
              write ('-');
     
          writeln;
     
          gotoxy(35, 2);
          writeln ('MEGA SENA DA UEPB');
     
          for i := 1 to 79 do
              write ('-');

          writeln;
          writeln;

     end;

     procedure numerosGerados;
     begin
          randomize;

          for i := 1 to 6 do begin
              // random(60) retorna números de 0 à 59, daí a importância de incrementá-lo.
              numerosSorteados[i] := 1 + random(60);
              // Garantindo que os números sejam todos distintos entre si.
              if (i > 1) then
                      for j := 1 to (i - 1) do
                          if (numerosSorteados[i] = numerosSorteados[j]) then
                             i := i - 1;

          end;

          // Exibindo os números escolhidos.
          writeln (' NUMEROS SORTEADOS:');
          textcolor(random(16)+1);
          for i := 1 to 6 do             		
              write('   ', numerosSorteados[i]);
          writeln;
          writeln;
          writeln;
     end;

     // Programa Principal.
     begin

     			
          repeat   
          				
									clrscr;              
                	cabecalho;
                	
                	numerosGerados;
                	
                	textcolor(15);
                	write(' PRESSIONE QUALQUER TECLA PARA PARAR O SORTEIO. ');
                	delay(200);                  
                           
          until Keypressed;	


readkey;
end.