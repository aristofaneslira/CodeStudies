a = int(raw_input("Digite o primeiro termo da p.a.: "))
r = int(raw_input("Digite a razao da p.a.: "))
n = int(raw_input("Digite a quantidade de termos da p.a.: "))
ultimo = int((a + (n - 1) * r) + 1)

for i in range(a,ultimo,r):
     print i



