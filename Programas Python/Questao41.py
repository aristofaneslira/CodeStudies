# coding: utf-8

n = int(raw_input("n? "))
c = raw_input("c? ")
busca = c.upper()

for i in range(n):
    palavra = raw_input("palavra? ")
    if palavra[0].upper() == busca:
       print palavra, "começa com", c
    else:
       print palavra, "não começa com", c
 

