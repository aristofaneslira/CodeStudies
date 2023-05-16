#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 140

def devedores(contas):
    cont = 0
    for chave in contas.keys():
        if contas.get(chave) < 0:
            cont +=1
    return cont

contas = { 'Ana':1000, 'Antonio':-500, 'William':0, 'Carlos':2500, 'Kate':-1300 }
assert devedores(contas) == 2
#print devedores(contas)
