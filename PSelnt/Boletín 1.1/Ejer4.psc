Algoritmo Ejer4
	total <- 0
	Escribir 'Introduce un número positivo:'
	Leer numP
	Mientras numP<=0 Hacer
		Escribir 'Número no valido, pruebe de nuevo:'
		Leer numP
	FinMientras
	numS <- numP
	Repetir
		total <- total+numS
		numS <- numS-1
	Hasta Que numS=0
	Escribir 'La suma de los primeros ', numP, ' números es: ', total
FinAlgoritmo
