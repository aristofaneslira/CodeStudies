#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 72

num = int(raw_input())
sequencia = raw_input()

sequencia = sequencia.split()
lista = []
cont = 0
for  i in sequencia:
    lista.append(i)
    if num == int(i):
       cont += 1
if cont > len(lista) / 2:
   print "sim"
else:
   print "nao" 


