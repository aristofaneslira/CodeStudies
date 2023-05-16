#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 73

lista = []
cont_p = 0
while True:
    palavra = raw_input()
    if palavra == "***":
        break          
    for letra in palavra.upper():
         if letra == "O":
             cont_p += 1   
    
print "Palavras:", cont_p 
