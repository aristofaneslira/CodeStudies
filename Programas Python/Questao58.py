#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 58

valor = 0
quant_v = 0
soma_v = 0

while True:
    valor = int(raw_input())
    if valor == 9999:
       break
    else:
       quant_v += 1
       soma_v += valor
    media = soma_v / quant_v
print float(media)
