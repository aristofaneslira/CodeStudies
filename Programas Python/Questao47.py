lista_2 = []
while True:
   palavra = raw_input()
   if palavra == "fim":
      break
   else:      
      lista = []
      
      for vogal in palavra:
         if vogal in "AEIOU" or vogal in "aeiou":
            lista.append(vogal)          
      if lista != []: 
         lista_2.append(lista[0])
      else: 
         lista_2.append("-")
        
for i in range(len(lista_2)):
    print lista_2[i]      

