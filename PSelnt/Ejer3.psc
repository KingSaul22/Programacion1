Algoritmo Ejer3
	Escribir 'Introduzca la cantidad de números que desea indicar:'
	Leer numP
	Mientras numP<=0 Hacer
		Escribir 'Cantidad erronea, pruebe de nuevo:'
		Leer numP
	FinMientras
	Escribir 'A continuación podrá introducir un número y se le indicará si es par o impar.'
	Mientras numP>0 Hacer
		Escribir 'Introduzca un número:'
		Leer numA
		Si numA % 2=entero Entonces
			Escribir numA, ' es par'
		SiNo
			Escribir numA, ' es impar'
		FinSi
		numP <- numP-1
	FinMientras
FinAlgoritmo
