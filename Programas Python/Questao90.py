#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 90

import math
lado_1 = int(raw_input("lado 1? "))
lado_2 = int(raw_input("lado 2? "))

area = int(lado_1 * lado_2)
diagonal = int(math.sqrt(((lado_1**2) + (lado_2**2))))

print "---"
print "area:", area
print "diagonal:", diagonal


