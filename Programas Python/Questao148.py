#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 148

def agrupa_pares_impares(lista):
    dic = {}
    pares = []
    impares = []
    for num in lista:
        if num % 2 == 0:
            pares.append(num)
        else:
            impares.append(num)
    dic['pares'] = pares
    dic['impares'] = impares
    return dic

#print agrupa_pares_impares([10, 24, 97, 88])
assert agrupa_pares_impares([10, 24, 97, 88]) == {"pares":[10, 24, 88], "impares":[97]}
assert agrupa_pares_impares([11, 23, 35]) == {"pares":[ ], "impares":[11, 23, 35]}
