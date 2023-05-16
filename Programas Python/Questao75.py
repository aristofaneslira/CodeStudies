#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 75

palavra_1 = raw_input()
palavra_2 = raw_input()

lista_1 = []
lista_2 = []
ocorrida = ""
for letra in palavra_1:
    lista_1.append(letra)
for letra in palavra_2:
    if letra in lista_1:    
        lista_2.append(letra)
for i in lista_2:
   ocorrida += i
print ocorrida

