cont = 0
A = [12,11,6,3,9,15,14,7,6,10,12,11,6,3,9,15,14,7,6,10,12,11,6,3,9,15,14,7,6,10,12,11,6,3,9,15,14,7,6,10,12,11,6,3,9,15,14,7,6,10,12,11,6,3,9,15,14,7,6,10,12,11,6,3,9,15,14,7,6,10,12,11,6,3,9,15,14,7,6,10,12,11,6,3,9,15,14,7,6,10,12,11,6,3,9,15,14,7,6,10,1000000]

k = 0
for i in A:
	cont = cont + 2
	if i > k:
		cont = cont + 1
		k = i
		cont = cont + 1

auxiliar = []
for i in range(k+1):
	cont = cont + 2
	auxiliar.append(0)
	cont = cont + 1
	
for i in A:
	cont = cont + 2
	auxiliar[i] = auxiliar[i]+1
	cont = cont + 1
	
A = []

for i in range(len(auxiliar)):
	cont = cont + 2
	if(auxiliar[i]>0):
		cont = cont + 1
		for j in range(auxiliar[i]):
			A.append(i)
			cont = cont + 1

#print(A)
print("Contador: ", cont)