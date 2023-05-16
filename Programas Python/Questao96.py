#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 96

N = int(raw_input())
L = int(raw_input())


lista = []
lista_2 = []
for i in range(N):
    titulos = raw_input().split(",")
    lista.append(titulos[0])
    lista_2.append(titulos[1])

for i in range(len(lista)):
    x = len(lista[i]) + len(lista_2[i])
    quant = L - x
    print "%s %s %s" % (lista[i],"." * quant,lista_2[i])

    
