#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 110

def alarme(dia,ferias):
    if ferias:
       if 1 <= dia <= 5:
          return "10:00"
       else:
          return
    else:
       if 1 <= dia <= 5:
          return "6:00"
       else:
          return "10:00"

assert alarme(1, False) == "6:00"

assert alarme(5, True) == "10:00"

assert alarme(0,False) == "10:00"
