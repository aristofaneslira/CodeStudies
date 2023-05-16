Program Calc_2grau ;
VAR x1, x2, delta, a, b, c : real;
Begin

write('Digite o valor de a: ');
read(a);
write('Digite o valor de b: ');
read(b);
write('Digite o valor de c: ');
read(c);


delta := (b*b) - (4 * a * c);

if a = 0 then 
	  begin
		write('"A" tem que ser diferente de "0"');
		end
		else if (delta > 0) then 
			begin
				x1 := ((-b + sqrt(delta)) / (2*a)); 
				x2 := ((-b - sqrt(delta)) / (2*a)); 
				write('Existem duas raizes',' X1 = ', x1 ,' e X2 = ', x2)
			end
	
		else if (delta = 0) then 
			begin
				x1 := ((-b + sqrt(delta)) / (2*a));
				x2 := ((-b - sqrt(delta)) / (2*a));
				write('Duas raizes iguais',' X1 = ', x1,' e X2 = ', x2);
		  end
		  
		else if (delta < 0) then
			begin
		 		write('Não pertence aos reais');
   		end;
End.