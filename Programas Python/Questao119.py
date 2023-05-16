#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 119

def filtra_lista(num, lista):
    nova_lista = [lista[i] for i in range(len(lista)) if i % num == 0]
    return nova_lista

lista1 = [0,1,2,3,4,5,6]

lista2 = [2,3,5,7,11,13,17]

print filtra_lista(2, lista1),filtra_lista(40, lista2)

assert filtra_lista(2, lista1) == [0,2,4,6]

assert filtra_lista(3, lista1) == [0,3,6]

assert filtra_lista(4, lista2) == [2,11]

assert filtra_lista(40, lista2) == [2]
