#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 79

palavra1 = raw_input()
palavra2 = raw_input()

indice = 0
nao_ocorre = ""

for i in palavra1:
   if not i in palavra2:
      nao_ocorre += palavra1[indice]
   indice += 1

if nao_ocorre != "":
   print nao_ocorre
