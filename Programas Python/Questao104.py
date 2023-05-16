#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 104

def divisor(num,lista):
    for numero in lista:
       if numero % num == 0:
          indice = numero
          break 
    return lista.index(indice)


lista1 = [100,10,40,50]

lista2 = [3,15,50,23,5]

print divisor(10, lista1)

assert divisor(10, lista1) == 0

assert divisor(5, lista2) == 1 
