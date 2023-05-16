#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 95

lista = []
lista_2 = []
cont = 0
while True:
   nome = raw_input().split()
   if nome[0] == "fim":
       break
   cont += 1
   telefone = raw_input()
   lista.append((nome[-1] + ", " + " ".join(nome[0:len(nome) - 1]))[0:16])
   lista_2.append(telefone)

for i in range(len(lista)):
    if len(lista_2[i]) > 14:
       print "%-16s|%-s" % (lista[i], "***")
    else:  
       print "%-16s|%-14s" % (lista[i], lista_2[i]) 
