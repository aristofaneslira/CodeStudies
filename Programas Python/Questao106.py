#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 106

def multa(velocidade, ehAniversario):
    if ehAniversario:
       if velocidade < 2 * 80:
          multa = 0
       elif 2 * 81 < velocidade < 2 * 100:
          multa = 1
       elif velocidade > 2 * 101:
          multa = 2
    else:
       if velocidade < 80:
          multa = 0
       elif 81 < velocidade < 100:
          multa = 1
       elif velocidade > 101:
          multa = 2
    return multa

assert multa(90, False) == 1

assert multa(120, False) == 2

assert multa(90, True) == 0

assert multa(190, True) == 1
