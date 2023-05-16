#LabProg1
#Aristofanes Santos de Lira - 21121396
#Questao 128

agenda = {}
def adiciona(nome,fone):
    agenda[nome] = fone


while True:
    digite = raw_input().split(None,1)
    comando = digite[0]        
    if comando == 'fim':
        break
    elif comando == 'adiciona':
       dados = digite[1]
       nome, fone = tuple(dados.split(' = ')) 
       adiciona(nome,fone)
       print "ok"
    elif comando == 'contato':
       dados = digite[1] 
       if agenda.has_key(dados):
          print 'contato:', dados   
          print 'fone:', agenda.get(dados)
       else:
           print 'contato inexistente:', dados
    elif comando == 'busca':
        dados = digite[1]
        for i in range(len(agenda.keys())):
            if dados.upper() in agenda.keys()[i].upper():
                print 'contato:', agenda.keys()[i]   
                print 'fone:', agenda.get(agenda.keys()[i])
    elif comando == 'listagem':
        for i in range(len(agenda.keys())):
            print 'contato:', sorted(agenda.keys())[i]   
            print 'fone:', agenda.get(sorted(agenda.keys())[i])
            
            
        
            
            
                
