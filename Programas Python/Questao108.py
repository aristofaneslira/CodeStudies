def z_inicial(lista):
    lista_z = []
    for palavra in lista:
        if palavra[0].upper() == "Z":
           lista_z.append(palavra)
    return lista_z

lista1 = ["zumbi","Zeca","Recife"]

lista2 = ["livro", "cd", "software"]

print z_inicial(lista1),z_inicial(lista2)

assert z_inicial(lista1) == ["zumbi","Zeca"]

assert z_inicial(lista2) == []     
