#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 114

def matriz_produto_escalar(matriz, k):
    matriz_2 = matriz[:]
    for i in range(len(matriz_2)):
        matriz_2[i] = [num * k for num in matriz_2[i]]            
    return matriz_2


