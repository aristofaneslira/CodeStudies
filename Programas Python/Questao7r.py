import math
catet = int(raw_input("Digite um cateto:"))
hipotenusa = int(raw_input("Digite a hipotenusa:"))
cateto = math.sqrt(((hipotenusa**2)-(catet**2)))
print "Segundo cateto =", int(cateto)
