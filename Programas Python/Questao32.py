#coding: utf-8

lado1 = int(raw_input())
lado2 = int(raw_input())
lado3 = int(raw_input())

if lado1 < lado2 + lado3 and lado2 < lado1 + lado3 and lado3 < lado2 + lado1:
    if lado1 == lado2 == lado3:
        print "Equilátero"
    elif lado1 == lado2 or lado1 == lado3 or lado2 == lado3:
        print "Isósceles"   
    elif not lado1 == lado2 == lado3:
        print "Escaleno"        
else:
  print "Não é triângulo"

