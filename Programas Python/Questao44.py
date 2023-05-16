lista = []
while True:
   par = raw_input()
   par = par.split()
   if float(par[0]) == -1 and float(par[1]) == -1:
       break
   else:
       produto = float(par[0]) * float(par[1])
       lista.append(produto)
for i in lista:
    print i
