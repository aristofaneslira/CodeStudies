num = int(raw_input())

lista = []
for i in range(num):
    resto = num % 2
    num = num / 2
    lista.append(str(resto))
    if num == 0:
        break
lista = lista[::-1]
print "".join(lista)
   
     
