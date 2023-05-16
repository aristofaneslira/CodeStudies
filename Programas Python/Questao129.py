#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 129

def transcreve_numero(numero):
    lista = []
    transcreve = {'0':'zero','1':'um','2':'dois','3':'tres','4':'quatro','5':'cinco','6':'seis','7':'sete','8':'oito','9':'nove'}
    for num in numero:
        if transcreve.has_key(num):
            lista.append(transcreve.get(num))        
    return lista
   

print transcreve_numero("2101-1500")

transcricao = transcreve_numero("2101-1500")

assert transcricao == ["dois", "um", "zero", "um", "um", "cinco", "zero", "zero"]          
