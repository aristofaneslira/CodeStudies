#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 121

def cria_login(nome):
    lista = nome.split()
    login = lista[0]
    lista.pop(0)
    if 'do' in lista:
        lista.remove('do')
    elif 'da' in lista:
        lista.remove('da')
    elif 'de' in lista:
        lista.remove('de')
    for nome in lista:
        login += nome[0]    
    return login.lower()

print cria_login("Matheus Gaudencio do Rego")

assert cria_login("Matheus Gaudencio do Rego") == "matheusgr"

assert cria_login("Eliane Araujo") == "elianea"

assert cria_login("Dalton Serey Guerrero") == "daltonsg"
