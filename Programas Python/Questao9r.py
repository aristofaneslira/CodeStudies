# coding: utf-8
import math
ponto = raw_input("Digite os pontos (x1,y1):")
ponto = ponto.split()
cateto_a = 0-int(ponto[0])
cateto_b = 0-int(ponto[1])
distancia = math.sqrt(cateto_a**2 + cateto_b**2)
print "Distancia:", distancia
inclinacao = cateto_b/cateto_a
print "Inclinação:", int(math.degrees(inclinacao)),"º graus"
