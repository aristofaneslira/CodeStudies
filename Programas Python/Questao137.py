#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 137

def professores(alocacao, disciplina):
    if alocacao.has_key(disciplina):
        return len(alocacao.get(disciplina))
    return 0

alocacao = {"P1": ['Jorge', 'Dalton','Wilkerson'],"IC": ['Andrey', 'Joseana'],"P2": ['Livia', 'Raquel', 'Nazareno'],"LPT": ['Marli']}
dic = {}
print professores(dic, 'P1')
