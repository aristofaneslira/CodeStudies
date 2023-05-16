#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 101

def divisores_proprios(x):
    lista = []
    for i in range(1,x):
        if x % i == 0:
           lista.append(i)
    return lista

def eh_perfeito(x):
    eh_perfeito = False
    lista = divisores_proprios(x)
    soma = sum(lista)    
    if soma == x:
       eh_perfeito = True
    return eh_perfeito 

#def eh_perfeito(x):
   #return sum(divisores_proprios(x)) == x   


assert eh_perfeito(6)

assert not eh_perfeito(5)
