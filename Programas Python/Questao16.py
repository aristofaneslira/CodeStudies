#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 16

import math

km_i = float(raw_input("Km inicial? "))
km_f = float(raw_input("Km final? "))
litros = float(raw_input("Litros? "))
total = float(raw_input("Total recebido? "))

consumo = (km_f - km_i) / litros
lucro = total - (litros*2.55)

print "Consumo em Km/L:",math.trunc(consumo)
print "Lucro liquido:",lucro
