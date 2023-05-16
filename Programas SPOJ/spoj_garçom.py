N = int(raw_input())

quebro = 0
for i in range(N):
    bandeja = raw_input().split()
    L = int(bandeja[0])
    C = int(bandeja[1])
    if L > C:
      quebro += C
print quebro
