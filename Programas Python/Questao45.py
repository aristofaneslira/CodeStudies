#coding: utf-8

num_1 = int(raw_input("Número 1: "))    
if num_1 < 0 or num_1 > 100:
     print "Número 1 inválido. Por favor, digite novamente."
     num_1 = int(raw_input("Número 1: "))

num_2 = int(raw_input("Número 2: "))
if num_2 < 0 or num_2 > 100:
     print "Número 2 inválido. Por favor, digite novamente."
     num_2 = int(raw_input("Número 2: "))
    
print "Soma:", num_1 + num_2
