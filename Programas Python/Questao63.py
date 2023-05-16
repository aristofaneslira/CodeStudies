#LabProg I
#Aristofanes Santos de Lira - 21121396
#Questao 63

palavra = raw_input()

lista = []
lista_2 = []
asterisco = ""
for letra in palavra:
    lista.append(letra)

palavra_nova = palavra[0::2]
for letra in palavra_nova:
    lista_2.append(letra)
if len(lista) > 1: 
    for i in range(len(lista_2)):        
        asterisco += palavra_nova[i]+"*"
    print asterisco     
else:
    print palavra    

