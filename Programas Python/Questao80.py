#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 80

num = raw_input()
lista = raw_input()
lista = lista.split()

lista_2 = []            
if int(lista.count(num)) > 1:
   for j in lista:
       lista_2.append(j)
       for i in range(len(lista_2)):
           if num == lista_2[i]:
               indice = i
   print indice
else:
   print "-1"
