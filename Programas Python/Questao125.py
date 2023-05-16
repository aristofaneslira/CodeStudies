def eh_bissexto(ano):
    return (ano % 4 == 0) == (not ano % 100 == 0) == (ano % 400 == 0)   

def conta_dias(dia, mes, ano):
    dias = 0
    for meses in range(1,1 + mes):
        if 1 < meses < 7:
            if mes == 2:
                if eh_bissexto(ano):
                    dias += 29
                else:
                    dias += 28
            else:
                if meses % 2 == 0:
                    dias += meses * 30
                else:
                    dias += meses * 31
        else:
            if mes % 2 == 0:
                dias += meses * 31
            else:
                dias += meses * 30
    dias -= 30 - dia
    return dias
    

print conta_dias(10, 1, 2000),conta_dias(20, 2, 2011),conta_dias(31, 12, 2011)

assert conta_dias(10, 1, 2000) == 10

assert conta_dias(20, 2, 2011) == 51

assert conta_dias(31, 12, 2011) == 365

            
            
