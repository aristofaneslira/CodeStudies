cont_p = 0
while True:
    cont_v = 0
    cont_c = 0
    palavra = raw_input()
    cont_p += 1 
    for letra in palavra.upper():
        if letra in "AEIOU":
            cont_v += 1           
        else: 
            cont_c += 1
    if cont_c > cont_v:
        break       
print cont_p
             
