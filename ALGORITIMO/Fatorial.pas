Program Fatorial_REPEAT ;
VAR fatorial, i, N: integer ;       
Begin 
    
	write('Informe o Valor de N: ');
	read(N);   	

	fatorial:= 1;
	i:= 1;
	REPEAT  
	    fatorial:= fatorial * i;
	    i:= i+1;
	UNTIL N<i;    
         
    write('O Valor de ', N, ' Fatorial é: ', fatorial);
    
    
 End.
 

