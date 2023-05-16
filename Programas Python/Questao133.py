#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 133

def turma_pratica(alocacao, turma):
    cont = 0
    for chave in alocacao.keys(): 
        if turma == alocacao.get(chave):
           cont += 1   
    return cont

alocacao = {"Nathan": 4,"Isis": 3,"Melissa": 5,"Davi": 2,"Aristofanes": 4}

print turma_pratica(alocacao, 4),turma_pratica(alocacao, 1),turma_pratica(alocacao, 5) 

assert turma_pratica(alocacao, 4) == 2

assert turma_pratica(alocacao, 1) == 0

assert turma_pratica(alocacao, 5) == 1 
