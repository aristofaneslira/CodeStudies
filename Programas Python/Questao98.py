def conta_palavras(k, palavras):
    cont = 0
    for i in palavras.split(":"):
        if len(i) >= k:
            cont += 1
    return cont

assert conta_palavras(5, "zero:um:dois:tres:quatro:cinco") == 2
