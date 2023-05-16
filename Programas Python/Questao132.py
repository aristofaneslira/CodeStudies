#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 132

def num_respostas(matriz):
    cont_resposta = 0
    for i in range(len(matriz)):
        for j in range(len(matriz[0])):
            if matriz[i][j] != None:
               cont_resposta += 1
    return cont_resposta

m1 = [[0,    1,    0,      1  ],[1,    1,    None,   0   ],[1,    None, None,   None]]

m2 = [[1,    1,    0,      1  ],[1,    1,    None,   0   ],[1,    1,    1,      None]]

print num_respostas(m1), num_respostas(m2) 

assert num_respostas(m1) == 8

assert num_respostas(m2) == 10
