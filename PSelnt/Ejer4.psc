Algoritmo Ejer4
	total <- 0
	Escribir 'Introduce un n�mero positivo:'
	Leer numP
	Mientras numP<=0 Hacer
		Escribir 'N�mero no valido, pruebe de nuevo:'
		Leer numP
	FinMientras
	numS <- numP
	Repetir
		total <- total+numS
		numS <- numS-1
	Hasta Que numS=0
	Escribir 'La suma de los primeros ', numP, ' n�meros es: ', total
FinAlgoritmo
