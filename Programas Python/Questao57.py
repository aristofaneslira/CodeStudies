#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 57

cont = 0
par = 0
par_2 = 0
lista = []
while True:
    num = raw_input()
    num = num.split()
    x = int(num[0])
    y = int(num[1])
    cont += 1 
    if len(lista) < 2: 
       if x == 2**y:
          par = x
          par_2 = y
          lista.append(x)
          lista.append(y)          
    if cont == 5:
       break
print par, par_2
