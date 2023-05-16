#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 100

def divisores_proprios(x):
    lista = []
    for i in range(1,x):
        if x % i == 0:
           lista.append(i)
    return lista

assert divisores_proprios(12) == [1, 2, 3, 4, 6] 
