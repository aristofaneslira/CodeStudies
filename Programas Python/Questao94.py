#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 94

import math

valor_i = int(raw_input())
valor_f = int(raw_input())
delta = int(raw_input())

print "%s" % "-" * 19
for graus in range(valor_i,valor_f + 1,delta):
    rads = math.radians(graus)
    print "|%3d  %1.3f %4s00|" % (graus, math.sin(rads), math.cos(rads))

print "%s" % "-" * 19

