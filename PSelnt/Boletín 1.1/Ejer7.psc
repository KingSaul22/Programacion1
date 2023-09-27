Algoritmo Ejer7
	numBase <- 0
	numSuma <- 0
	Escribir '¿Cuantós datos desea introducir?'
	Leer numDatos
	Mientras numDatos<=0 Hacer
		Escribir 'Número no valido, escoja otro:'
		Leer numDatos
	FinMientras
	numBase <- numBase+numDatos
	Mientras numDatos>0 Hacer
		numDatos <- numDatos-1
		Escribir 'Introduzca un número:'
		Leer numIn
		numSuma <- numSuma+numIn
		Escribir numSuma
	FinMientras
	numSuma <- numSuma/numBase
	Escribir 'La media resulta en: ', numSuma
FinAlgoritmo
