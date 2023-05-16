#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 131

def periodos_prejuizos(custos, receita):
    lista = []
    for periodo in sorted(receita.keys()):
        if custos.get(periodo) > receita.get(periodo):
            lista.append(periodo)
    if len(lista)>= 1:
        return lista
    


custos = {0: 20, 3: 10, 4: 15, 7: 22, 8: 100}

receita = {0: 60, 3: 6, 4: 25, 8: 88, 9: 90}

print periodos_prejuizos(custos, receita)

assert periodos_prejuizos(custos, receita) == [3,8]

            
        
