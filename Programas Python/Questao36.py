N = int(raw_input())

soma = 0

for num in range(N):
    num = int(raw_input())
    if num % 5 == 0:
       soma += num

print soma
