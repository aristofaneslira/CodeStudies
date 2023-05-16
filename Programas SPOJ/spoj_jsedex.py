N = int(raw_input())

caixa = raw_input().split()
A = int(caixa[0])
L = int(caixa[1])
P = int(caixa[2])

if N <= A and N <= L and N <= P:
   print "S"
else:
   print "N" 
