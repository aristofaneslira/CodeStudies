#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 12

import math

a = float(raw_input("Comprimento? "))
b = float(raw_input("Largura? "))
c = float(raw_input("Altura? ")) 

area = 2 * (a * c + b * c)
quant_azulejo = area / 1.5

print "Quantidade de caixas:", math.trunc(math.ceil(quant_azulejo))

