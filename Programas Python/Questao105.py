#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 105

def tem_consoantes_iguais(palavra):
   anterior = []
   anterior.append(palavra[0])
   for i in range(1,len(palavra)):
      if anterior[-1].upper() == palavra[i].upper():
         return True
      anterior.append(palavra[i])
   return False

print tem_consoantes_iguais("carro"),tem_consoantes_iguais("brasil"),tem_consoantes_iguais("internet")

assert tem_consoantes_iguais("carro")

assert not tem_consoantes_iguais("brasil")

assert not tem_consoantes_iguais("internet")
