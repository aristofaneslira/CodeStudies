entrada = raw_input().split()
N = int(entrada[0])
C = int(entrada[1])

cont_E = 0
cont_S = 0
cont_C = 0
for i in range(N):
    sensor = raw_input().split()
    S = int(sensor[0])
    E = int(sensor[1])
    
    if cont_C > C:
       exede = "S"
    else:        
       exede = "N"
print exede 

