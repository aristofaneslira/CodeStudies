#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 56

produto = 1
cont = 0

while True:
    num = int(raw_input())
    if produto >= 1024:
       break
    else:
       produto *= num
       cont += 1
print cont, produto    
