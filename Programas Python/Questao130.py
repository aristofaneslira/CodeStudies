#Lab.Prog1
#Aristofanes Santos de Lira - 21121396
#Questao 130

def transcreve_valor(N):
    lista = []
    transcreve = {0:'zero',1:'um',2:'dois',3:'tres',4:'quatro',5:'cinco',6:'seis',7:'sete',8:'oito',9:'nove',10:'dez',11:'onze',12:'doze',13:'treze',14:'quartoze',15:'quinze',16:'desesseis',17:'desessete',18:'dezoito',19:'dezenove',20:'vinte',30:'trinta',40:'quarenta',50:'cinquenta',60:'sessenta',70:'setenta',80:'oitenta',90:'noventa',100:'cem',200:'duzentos',300:'trezentos',400:'quatrocentos',500:'quinhentos',600:'seisentos',700:'setecentos',800:'oitocentos',900:'novecentos'}
    if len(N) == 4:
        return 'mil'
    if len(N) == 1:
        return trancreve.get(N)
    if len(N) == 2:
        if transcreve.has_key(N):
            return trancreve.get(N)
        #return 
print transcricao(3) = "tres"

print transcricao(15) = "quinze"
    
