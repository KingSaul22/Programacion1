Algoritmo Ejer7
	numBase <- 0
	numSuma <- 0
	Escribir '�Cuant�s datos desea introducir?'
	Leer numDatos
	Mientras numDatos<=0 Hacer
		Escribir 'N�mero no valido, escoja otro:'
		Leer numDatos
	FinMientras
	numBase <- numBase+numDatos
	Mientras numDatos>0 Hacer
		numDatos <- numDatos-1
		Escribir 'Introduzca un n�mero:'
		Leer numIn
		numSuma <- numSuma+numIn
		Escribir numSuma
	FinMientras
	numSuma <- numSuma/numBase
	Escribir 'La media resulta en: ', numSuma
FinAlgoritmo
