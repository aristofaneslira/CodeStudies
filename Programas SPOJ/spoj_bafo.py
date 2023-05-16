cont = 0
vencedor = []
teste = 0
while True:
   R = int(raw_input())
   if R == 0:
      break   
   cont += 1
   cont_a = 0
   cont_b = 0
   for i in range(R):
         partida = raw_input().split()     
         cont_a += int(partida[0])
         cont_b += int(partida[1])
   if cont_a > cont_b:
        vencedor.append("Aldo")
   else:
        vencedor.append("Beto")  
for i in range(cont):
    teste += 1        
    print "Teste", teste, "\n", vencedor[i], "\n"

    
         

