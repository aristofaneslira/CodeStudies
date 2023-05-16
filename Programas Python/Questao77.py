#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 77

cont_p = 0
while True:
    palavra = raw_input()
    if palavra == "***":
       break
    lista = []
    for letra in palavra.upper():
        lista.append(letra)
    if lista[0] not in "AEIOU":
        cont_p += 1    
            
print "Palavras:", cont_p
