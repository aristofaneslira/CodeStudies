#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 69

soma = 0
while True:
    num = int(raw_input())
    if num % 2 == 0:
       soma += num
    if num < 0:
       break
print "Soma:", soma
