def maior_palavra(lista):
    maior = ""
    for palavra in lista:
        if len(palavra) > len(maior):
            maior = palavra
    return maior

lista1 = ["palavra", "exemplo", "computador", "mouse"]

lista2 = ["outra", "palavra", "como", "exemplo", "mouse"]


assert maior_palavra(lista1) == "computador"

assert maior_palavra(lista2) in ["palavra", "exemplo"]
