Algoritmo Ejer7b
	//numBase <- 0
	//numSuma <- 0
	Escribir '¿Cuantós datos desea introducir?'
	Leer numDatos
	Mientras numDatos<=0 Hacer
		Escribir 'Número no valido, escoja otro:'
		Leer numDatos
	FinMientras
	numBase <- numBase+numDatos
	Para variable<-numDatos Hasta 1 Con Paso -1 Hacer
		Escribir 'Introduzca un número:'
		Leer numIn
		numSuma <- numSuma+numIn
		//Escribir numSuma
	FinPara
	numSuma <- numSuma/numBase
	Escribir 'La media resulta en: ', numSuma
FinAlgoritmo
