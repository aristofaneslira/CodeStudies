#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 71

palavra1 = raw_input()
palavra2 = raw_input()

indice = 0
nao_ocorre = ""

for i in palavra2:
   if not i in palavra1:
      nao_ocorre += palavra2[indice]
   indice += 1
print nao_ocorre

