palavra = ""
quant_p = 0
soma_p = 0
vogais = 0
consoantes = 0

while True:
    palavra = raw_input()
    if palavra == "fim":
       break
    else:
       for i in palavra.lower():
          if i in 'aeiou':
             vogais += 1
          else:
             consoantes += 1

       quant_p = vogais + consoantes
       soma_p += 1
    media = quant_p / soma_p
print float(media)
