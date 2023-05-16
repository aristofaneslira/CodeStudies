item = raw_input().split()

cod = int(item[0])
descricao = item[1]
quant = int(item[2])
vunit = float(item[3])
total = quant * vunit
total_geral += total

print "%s" % "-" * 33

print "|%03d|%9s|%02d|%5f|%5f" % (cod,descricao,quant,vunit,total)

print "%s" % "-" * 33

print "|TOTAL GERAL R$ %f|" % total_geral

print "%s" % "-" * 33


print "%s" % "-" * 33
