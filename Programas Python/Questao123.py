#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 123

def conta_coincidencias(lista_1,lista_2):
    cont = 0
    if len(lista_1) == len(lista_2):
        for i in range(len(lista_1)):
            if lista_1[i] == lista_2[i]:
                cont += 1
    else:        
        lista_1.pop() or lista_2.pop()
    return cont

print conta_coincidencias([1,2,3,4],[5,6,7])

assert conta_coincidencias([1,2,3,4], [5,6,7]) == 0

assert conta_coincidencias([1,2,3,4], [2,3,3,4]) == 2

assert conta_coincidencias([1,2],[1,3]) == 1

            
