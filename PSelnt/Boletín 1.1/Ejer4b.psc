Algoritmo Ejer4b
	total <- 0
	Escribir 'Introduce un n�mero positivo:'
	Leer num
	Mientras num<=0 Hacer
		Escribir 'N�mero no valido, pruebe de nuevo:'
		Leer num
	FinMientras
	Escribir 'La suma de los primeros ', num, ' n�meros es:'
	Repetir
		total <- total+num
		num <- num-1
	Hasta Que num=0
	Escribir total
FinAlgoritmo
