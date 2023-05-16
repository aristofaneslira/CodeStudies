# coding: utf-8

valor = 0
quant_v = 0
soma_v = 0

while True:
    valor = float(raw_input("valor? "))
    if valor < 0:
       print "---"
       break
    else:
       quant_v += 1
       soma_v += valor
    media = soma_v / quant_v

print "Quantidade de valores:", quant_v
print "Soma dos valores:", soma_v
print "Média:", media
