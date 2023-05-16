#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 120

def filtra_lista(num, lista):
    for i in range(len(lista)):
        if i % num != 0:
           lista.remove(lista[i])
    return lista

lista1 = [0,1,2,3,4,5,6]

lista2 = [2,3,5,7,11,13,17]

print filtra_lista(2, lista1)

assert lista1 == [0,2,4,6]

filtra_lista(3, lista1)

assert lista1 == [0,6]

filtra_lista(3, lista2)

filtra_lista(2, lista2)

assert lista2 == [2, 17]
