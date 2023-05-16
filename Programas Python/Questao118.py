#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 118

def calcula_media(notas, pesos):
    media = 0
    soma = 0
    for i in range(len(notas)):
        media += notas[i]*pesos[i]
        soma += pesos[i]
    return (media / soma)

print calcula_media([5.0, 0.0, 7.5, 10.0], [4.0, 5.0, 2.0, 1.0])
        
assert calcula_media([10.0, 10.0, 10.0], [1.0, 2.0, 3.0]) == 10.0

assert calcula_media([5.0, 0.0, 7.5, 10.0], [4.0, 5.0, 2.0, 1.0]) == 3.75

assert calcula_media([4.0, 6.0],[5.0, 5.0]) == 5.0
