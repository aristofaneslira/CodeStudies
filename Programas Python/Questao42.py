n = int(raw_input("n? "))
lista = [1]
lista_2 = []
lista_3 = []

for j in range(n):
    for i in range(1,n+n,3):
        lista_2.append(i)
        x = i * lista[-1]
        lista.append(x)
for i in range (n):
   lista_3 = lista_3 + [lista[i]] + [lista_2[i]]
lista_3.pop(0)
for j in range(n):
    print lista_3[j]
        
    
    
    
         
