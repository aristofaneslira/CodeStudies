#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 113

def multiplica_por_escalar(matriz, k):
    for i in range(len(matriz)):
        matriz[i] = [num * k for num in matriz[i]]            
    return matriz

  
    
