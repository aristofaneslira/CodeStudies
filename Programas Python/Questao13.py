import math
salario_a = float(raw_input("Valor atual? "))
salario_n = float(raw_input("Novo valor? "))

reajuste = (salario_n - salario_a)*100 / salario_a

print "Reajuste de", str(reajuste) + "%"
