#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 93

palavra = raw_input()

lista = []
cont = 0
for letra in palavra.upper():
    if not letra in lista:
        cont += 1
        lista.append(letra)    
print cont  


