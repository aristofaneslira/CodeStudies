def prevogais(palavra):
    lista = []
    lista_2 = []
    for letra in palavra:
        lista.append(letra)
    for i in range(1,len(lista)): 
         if lista[i] in "AEIOU" or lista[i] in "aeiou":
             if lista[i - 1] != "AEIOU" or lista[i - 1] != "aeiou":
                 lista_2.append(lista[i - 1])
    return lista_2

assert prevogais("exemplo") == ['x', 'l']
assert prevogais("hiato") == ['h', 'i', 't']
            
            
