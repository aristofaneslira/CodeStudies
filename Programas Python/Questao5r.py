lado = int(raw_input("Digite o valor do lado:"))
pi = 3.1415
raio = lado / 2
area_circulo = pi * raio ** 2
area_quadrado = lado ** 2
assert area_quadrado > area_circulo
print "Area do circulo =", area_circulo
print "Area do quadrado =", area_quadrado
