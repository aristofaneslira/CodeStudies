#LabProg I
#Aristofanes Santos de Lira - 21121396
#Questao 68

num = int(raw_input())
fatorial = 1
for i in range(num):
    fatorial *= num
    num = num - 1
print fatorial
