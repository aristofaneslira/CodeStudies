N = int(raw_input())

distancia = 0
for i in range(N):
   tacografo = raw_input().split()
   distancia += int(tacografo[0]) * int(tacografo[1])
   
print distancia
