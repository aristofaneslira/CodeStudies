lista = []
cont = 0
while True:
    N = int(raw_input())
    if N == 0:
       break
    sequencia = raw_input().split()
    sequencia.insert(0,1)
    for j in sequencia:   
        if int(j) == sequencia.index(j):
             lista.append(j)
            
for i in range(len(lista)):
    cont += 1    
    print "Teste", cont,"\n", lista[i], "\n"

