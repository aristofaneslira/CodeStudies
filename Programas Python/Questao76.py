#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 76

soma = int(raw_input())
lista = raw_input()
lista = lista.split()

lista_2 = []
indice = 0
for i in range(len(lista)):
    for j in lista:
        if int(lista[i]) + i == soma:
            lista_2.append(j)
            indice = i
if len(lista_2) >= 1:
   print indice
else:
   print "-1" 
    
