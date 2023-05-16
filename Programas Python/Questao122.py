#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 122

def eh_vencedor_linea(tabuleiro):
    if 0 in tabuleiro:
        return True
    else: 
        return False

print eh_vencedor_linea([1,2,3,4,5,0])

assert eh_vencedor_linea([2,0,1])

assert not eh_vencedor_linea([1,2,3])

assert eh_vencedor_linea([1,2,3,4,5,0])
