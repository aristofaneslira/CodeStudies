#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 126

frase = raw_input().split()

for i in range(len(frase)):    
    print "%02d - %-s" % (i,frase[i])
