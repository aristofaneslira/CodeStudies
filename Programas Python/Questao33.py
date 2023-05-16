#coding: utf-8

ano = int(raw_input())

if ano % 4 == 0 and not ano % 100 == 0:
   print ano, "é bissexto"
elif ano % 400 == 0:
   print ano, "é bissexto"
else:
   print ano, "não é bissexto"
