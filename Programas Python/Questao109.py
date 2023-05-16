#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 109

def tem_vogais_adjacentes(palavra):
   anterior = []
   anterior.append(palavra[0])
   for i in range(1,len(palavra)):
      if anterior[-1].upper() in "AEIOU" and palavra[i].upper() in "AEIOU":
         return True
      anterior.append(palavra[i])
   return False 
      
print tem_vogais_adjacentes("orfeu"),tem_vogais_adjacentes("brasil"),tem_vogais_adjacentes("voo")

assert tem_vogais_adjacentes("orfeu")

assert not tem_vogais_adjacentes("brasil")

assert tem_vogais_adjacentes("voo")
