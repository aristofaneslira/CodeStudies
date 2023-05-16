cont = 0
lista = []
while True:
   V = int(raw_input())
   if V == 0:
      break
   lista.append(V)   
for i in range(len(lista)):
   cont += 1
   V = lista[i]
   cont_I = V / 50
   V = V % 50
   cont_J = V / 10
   V = V % 10  
   cont_K = V / 5
   V = V % 5
   cont_L = V / 1
   V = V % 1
            
   print "Teste", cont
   print cont_I, cont_J, cont_K, cont_L,"\n"

