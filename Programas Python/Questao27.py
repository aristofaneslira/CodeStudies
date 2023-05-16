palavra = str(raw_input())

lista = ['a','e','i','o','u']
lista2 = ['A','E','I','O','U']
for i in palavra:
    if i in lista or i in lista2:
        print "<"+i+"> sim"
    else:
        print "<"+i+"> nao" 
