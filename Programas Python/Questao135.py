#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 135

def turma_pratica(alocacao, turma):
    cont_pratica = 0
    for tupla in alocacao.values():
        if turma == tupla[1]:
            cont_pratica += 1
    return cont_pratica        



alocacao = {"Nathan": (2, 4),"Isis": (1, 3),"Melissa": (3, 5),"Davi": (2, 2),"Aristofanes": (2, 4)}

print turma_pratica(alocacao, 4)

assert turma_pratica(alocacao, 4) == 2

assert turma_pratica(alocacao, 1) == 0

assert turma_pratica(alocacao, 5) == 1
