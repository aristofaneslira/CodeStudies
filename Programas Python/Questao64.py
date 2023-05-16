num_1 = int(raw_input()) 
num_2 = int(raw_input())

soma = 0
if num_2 == 0:
   for i in range(num_1+1):
       soma += i 
else:
   for i in range(num_1,num_2 + 1):
       soma += i 
print soma
