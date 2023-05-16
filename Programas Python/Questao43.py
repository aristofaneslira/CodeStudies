lista = []

while True:
   num = int(raw_input())
   if num == -1:
      break
   else:
      lista.append(num)
      lista.sort() 

print "maior:", lista[-1]
print "menor:", lista[0]
   
    
