palavra = raw_input()
lista = []

for vogal in palavra:
   if vogal in "AEIOU" or vogal in "aeiou":
       lista.append(vogal)
if lista != []:
   print lista[0]
else:
   print "-"
   
      
