#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 124

def quantos_comeram(n_feijoadas, fila):
    cont = 0
    for grupo in fila:
        if grupo <= n_feijoadas:
            cont += grupo
            n_feijoadas -= grupo
    return cont

print quantos_comeram(5, [2, 3, 5])

assert quantos_comeram(10, [10, 10]) == 10

assert quantos_comeram(12, [10, 10]) == 10

assert quantos_comeram(2, [10, 10]) == 0

assert quantos_comeram(5, [2, 3, 5]) == 5
            
