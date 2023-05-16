#!/bin/python
#calculador de fatorial

n = int(raw_input())

resultado = 1

for x in range(1,n+1):

    resultado = x * resultado

print (n, resultado)
