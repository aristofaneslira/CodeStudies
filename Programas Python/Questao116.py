#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 116

def soma_matrizes(matriz_1, matriz_2):
    soma_matriz = [len(matriz_1[0])*[0] for i in range(len(matriz_1))]
    for i in range(len(soma_matriz)):
        for j in range(len(soma_matriz[0])):
            soma_matriz[i][j] = (matriz_1[i][j] + matriz_2[i][j])
    return soma_matriz    

mA = [[1, 1], [1, 1]]

print soma_matrizes(mA, mA)
print mA
assert soma_matrizes(mA, mA) == [[2, 2], [2, 2]] 
