#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 107

def encontra_menores(num,lista):
    for n in lista:
        if num > n:
           return n
        else:
           return int(-1)

lista1 = [100,200,300,400]

lista2 = [1,3,5,7,9,11]

assert encontra_menores(100, lista1) == -1

assert encontra_menores(4, lista2) == 1 
