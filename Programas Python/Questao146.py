def colunas_negativas(matriz):
    lista = []
    for i in range(len(matriz[0])):
        soma = 0
        soma += matriz[i][i]
        if soma < 0:
            lista.append(i)
    return lista

assert colunas_negativas([[1, -3], [3, -1], [-2, -4]]) == [1]
assert colunas_negativas([[1, 3, -2], [-3, -1, -4]]) == [0, 2]
