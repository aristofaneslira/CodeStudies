#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 117

def mult_matrizes(matriz_A, matriz_B):
    if len(matriz_B[0]) == len(matriz_A):
        mult_matriz = [len(matriz_B[0])*[0] for i in range(len(matriz_A))]
        for i in range(len(matriz_B[0])):
            for j in range(len(matriz_A[0])):
                mult_matriz[0][i] += matriz_A[0][j] * matriz_B[j][i]        
                mult_matriz[1][i] += matriz_A[1][j] * matriz_B[j][i]                        
        return mult_matriz

mA = [[0, 1, 2], [1, 1, 3]]

mB = [[2, 1], [2, 2], [0, 3]]

#print mult_matrizes(mA, mB)
assert mult_matrizes(mA, mB) == [[2, 8], [4, 12]]

m1 = [[2,2,-1],[7,1,-4],[8,1,3]]
m2 = [[2,3,0],[0,2,-1],[1,0,2],[3,1,4]]    
assert mult_matrizes(m1,m2) == [[25,7,-14],[6,1,-11],[18,4,5],[45,11,5]]
