
n = int(raw_input())

if 1 <= n <= 1000000: 
    
    
    instancia = 0
    fatorial = 1    
         
    for i in range(1,n+1):
    
        fatorial = i*fatorial
    
    instancia += 1
            
print "Instancia", instancia
print fatorial
   
#fazer instancia e primeiro numero antes do 0


