# coding: utf-8
import math
pontos = raw_input("Digite os pontos A(x1,y1) e B(x2,y2):")
pontos = pontos.split()
cateto_a = int(pontos[2])-int(pontos[0])
cateto_b = int(pontos[3])-int(pontos[1])
distancia = math.sqrt(cateto_a**2 + cateto_b**2)
print "Distancia:", distancia
inclinacao = cateto_b/cateto_a
print "Inclinação:", int(math.degrees(inclinacao)),"º graus"
