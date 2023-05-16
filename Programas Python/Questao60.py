palavra = raw_input()

lista = []
lista_2 = []
for letra in palavra:
    lista.append(letra)
    lista_2.append(letra)
lista_2.reverse()
for i in range(len(lista)): 
    if lista[i] == lista_2[i]:
       resultado = "SIM"
    else:
       resultado = "NAO"
print resultado
