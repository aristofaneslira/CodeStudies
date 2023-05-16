#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 102

def conta_letra(letra, frase):
    cont = 0
    for i in frase.upper():
        if i == letra.upper():
           cont += 1
    return cont

assert conta_letra("a", "Abacaxi e laranja") == 6
