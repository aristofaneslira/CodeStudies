#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 92

cont = 0
while True:
    palavra = raw_input()    
    if palavra[0].upper() == "A":
        break
    cont += 1
print "---"
print cont, palavra
