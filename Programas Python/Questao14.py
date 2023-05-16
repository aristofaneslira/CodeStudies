valor_carro = float(raw_input("Valor de venda? "))

valor_custo = valor_carro / 1.4
icms = valor_custo * 18/100
ipi = valor_custo * 13/100
pis = valor_custo * 1.4/100
cofins = valor_custo * 7.6/100

print "ICMS:", icms
print "IPI:", ipi
print "PIS:", pis
print "Cofins:", cofins
print "Valor sem impostos:", valor_custo
