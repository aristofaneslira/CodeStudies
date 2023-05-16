#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 15

import math

valor = float(raw_input("Valor? "))
quadrado = valor**2

print "Sem arredondamento:", quadrado
print "Com arredondamento para cima:", math.ceil(quadrado)
print "Com arredondamento para baixo:", math.floor(quadrado)
print "Valor truncado:", math.trunc(quadrado)

