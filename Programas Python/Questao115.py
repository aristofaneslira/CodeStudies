#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 115

def multiplica_por_escalar(matriz, k):
    for i in range(len(matriz)):
        matriz[i] = [num * k for num in matriz[i]]            
    return matriz

matriz = raw_input().split()
M = int(matriz[0])
N = int(matriz[1])

lista = []
for num in range(M):
    A = raw_input().split()
    lista.append(A)   

k = int(raw_input())

for i in range(len(lista)):
    for j in range(len(lista[0])):
        lista[i][j] = int(lista[i][j])
   
matriz = multiplica_por_escalar(lista, k)

for i in matriz:   
   for j in i:
      print j,
   print     


