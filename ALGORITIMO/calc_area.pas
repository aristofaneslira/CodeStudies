Program CALCULA_AREA;
Var opcao, base, base_menor, altura, raio, diagonal, diagonal_menor: integer;

Begin

write('Escolha a figura para calcular a area: ');
write('1) retangulo - 2) triangulo - 3) losango - 4) trapezio - 5) circulo: '); 
read(opcao);
if (opcao = 1) then
		begin
				writeln('Area do retangulo');
				write('Digite o valor da base: ');
				read(base);
				write('Digite o valor da altura: ');
				read (altura);
				write('Valor da area deste retangulo: ', base*altura);
				base:=0; //resetando o valor das variaveis que podem ser reutilizadas;
				altura:=0;
		end;

if (opcao = 2) then
		begin
				writeln('Area do triangulo');
				write('Digite o valor da base: ');
				read(base);
				write('Digite o valor da altura: ');
				read (altura);
				write('Valor da area deste triangulo: ', (base*altura)/2);
				base:=0; //resetando o valor das variaveis que podem ser reutilizadas;
				altura:=0; 		
		end;

if (opcao = 3) then
		begin
				writeln('Area do losango');
				write('Digite o valor da diagonal maior: ');
				read(diagonal);
				write('Digite o valor da diagonal menor: ');
				read (diagonal_menor);
				write('Valor da area deste losango: ', (diagonal*diagonal_menor)/2);
		end;		

if (opcao = 4) then
		begin
				writeln('Area do trapezio');
				write('Digite o valor da base maior: ');
				read(base);
				write('Digite o valor da base menor: ');
				read (base_menor);
				write('Digite o valor da altura:');
				read (altura);
				write('Valor da area deste trapezio: ', ((base+base_menor)*altura)/2);
				base:=0; //resetando o valor das variaveis que podem ser reutilizadas;
				altura:=0; 
		end;

if (opcao = 5) then
		begin
				writeln('Area do circulo');
				write('Digite o valor do raio: ');
				read(raio);  				
				write('Valor da area deste circulo: ', (3.14*(raio*raio)));
				 
		end;

  
End.