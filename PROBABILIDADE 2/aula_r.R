#y(comprimento da criança)
#x1(idade)
#x2(comprimento ao nascimento)
#x3(peso no nascimento) #x4(tamanho do peito no nascimento)

y=c(57.5,52.8,61.3,67,53.5,62.7,56.2,68.5,69.2)
x1=c(78,69,77,88,67,80,74,94,102)
x2=c(48.2,45.5,46.3,49,43,48,48,53,58)
x3=c(2.75.2.15,4.41,5.52,3.21,4.32,2.31,4.3,3.71)
x4=c(29.5,26.3,32.2,27.2,27.7,28.3,30.3,28.7)

#### PASSO 1

modelo0=lm(y~x1+x2+x3+x4);modelo0
summary(modelo0)
anova(modelo0)

modelo1=lm(y~x1);modelo1
summary(modelo1)
anova(modelo1)

modelo2=lm(y~x2;modelo2
summary(modelo2)
anova(modelo2)

modelo3=lm(y~x3);modelo3
summary(modelo3)
anova(modelo3)

modelo4=lm(y~x4);modelo4
summary(modelo4)
anova(modelo4)

#### PASSO 2  modelo5=lm(y~x1+x2;modelo5
summary(modelo5)
anova(modelo5)

modelo6=lm(y~x1+x3);modelo6
summary(modelo6)
anova(modelo6)

modelo7=lm(y~x1+x4);modelo7
summary(modelo7)
anova(modelo7)

#### PASSO 3

modelo8=lm(y~x1+x3+x2);modelo8
summary(modelo8)
anova(modelo8)

modelo9=lm(y~x1+x3+x4);modelo9
summary(modelo9)
anova(modelo9)

####

modelo10=lm(y~x3+x1);modelo10
summary(modelo10)
anova(modelo10)

modelo11=lm(y~x2+x3);modelo11
summary(modelo11)
anova(modelo11)


