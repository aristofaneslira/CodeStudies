Program Tabuada ;
Var num,i: integer;
Begin

write('Digite um numero: ');
read(num);

if (num>=1) and (num<=10) then
		for i:= 1 TO 10 DO
			begin
			writeln(num, ' X ', i, ' = ', num*i);
			end;
  
End.