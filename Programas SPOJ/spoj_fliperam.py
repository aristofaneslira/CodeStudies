bebe = raw_input().split()
N = int(bebe[0])
M = int(bebe[1])
lista = []
for i in range(N):
    pontos = int(raw_input())
    lista.append(pontos)
lista.sort()
lista.reverse() 
for i in range(M):
    print lista[i]
