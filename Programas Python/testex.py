nome = "Matheus Gaudencio do Rego"

nome = nome.split()
login = ""
for palavra in nome:
    if len(palavra) > 2:
       login += palavra + " "
print login


x = login[0] + login[len(login) - 1]
