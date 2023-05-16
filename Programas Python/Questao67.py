#LabProg I
#Aristofanes Santos de Lira - 21121396
#Questao 67

palavra = raw_input()
lista = []
dobro = ""
for letra in palavra:
    lista.append(letra)
for i in range(len(lista)):    
    dobro += palavra[i]*2
print dobro
