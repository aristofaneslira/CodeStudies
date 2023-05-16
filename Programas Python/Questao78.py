#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 78

palavra_1 = raw_input()
palavra_2 = raw_input()
palavra_3 = raw_input()

lista_1 = []
lista_2 = []
lista_3 = []
for letra in palavra_1:
    lista_1.append(letra)
for letra in palavra_2:
    lista_2.append(letra)
for letra in palavra_3:
    lista_3.append(letra)
if max(len(lista_2), len(lista_3), len(lista_1)) == len(lista_1):
   palavra_meio = palavra_1
if max(len(lista_2), len(lista_3), len(lista_1)) == len(lista_2):
   palavra_meio = palavra_2
if max(len(lista_2), len(lista_3), len(lista_1)) == len(lista_3):
   palavra_meio = palavra_3
if min(len(lista_2), len(lista_3), len(lista_1)) == len(lista_1):
   palavra_ponta = palavra_1
if min(len(lista_2), len(lista_3), len(lista_1)) == len(lista_2):
   palavra_ponta = palavra_2
if min(len(lista_2), len(lista_3), len(lista_1)) == len(lista_3):
   palavra_ponta = palavra_3

print palavra_ponta + palavra_meio + palavra_ponta
