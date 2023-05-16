#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 141

def esparsa(matriz):
    dic = {}
    for i in range(len(matriz)):
        for j in range(len(matriz[0])):
            if matriz[i][j] != 0:
                dic[i,j] = matriz[i][j]
    return dic

M = [[0,0,1], [0,0,0], [0,5,0],[6,0,0]]
dic = {(0,2):1, (2,1):5, (3,0):6}
M1= [[2,0,0], [0,0,3],[0,0,0],[0,0,1]]
dic1 = {(0,0):2, (1,2):3, (3,2):1}



assert esparsa(M) == dic
assert esparsa(M1) == dic1
