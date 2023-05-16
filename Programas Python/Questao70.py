#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 70

palavra_1 = raw_input()
palavra_2 = raw_input()

lista_1 = []
lista_2 = []
for letra in palavra_1:
    lista_1.append(letra)
for letra in palavra_2:
    lista_2.append(letra)
if len(lista_1) < len(lista_2):
    print palavra_1 + palavra_2 + palavra_1
else:
    print palavra_2 + palavra_1 + palavra_2
