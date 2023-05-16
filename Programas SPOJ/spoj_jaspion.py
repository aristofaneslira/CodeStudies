T = int(raw_input())

for i in range(T):
    instancia = raw_input().split()
    M = int(instancia[0])
    N = int(instancia[1])
    lista = []
    for d in range(M):
        palavra = raw_input()
        lista.append(palavra)
    for p in range(len(lista)):
        if p % 2 == 0:
            dic[lista[p]] = lista[p+1]
    letra = []
    for l in range(N):
        musica = raw_input().split()
        letra.append(musica)
    for t in range(len(letra)):
        
        
