#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 112

def altera_vetor_por_escalar(vetor, escalar):
    for i in range(len(vetor)):
       vetor[i] = vetor[i] * escalar    
    return vetor

vetor_1 = [1, 2, 3]

print altera_vetor_por_escalar(vetor_1, -1)

assert vetor_1 == [-1, -2, -3]

print altera_vetor_por_escalar(vetor_1, 2)

assert vetor_1 == [-2, -4, -6]
