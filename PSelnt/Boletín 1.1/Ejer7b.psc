Algoritmo Ejer7b
	//numBase <- 0
	//numSuma <- 0
	Escribir '�Cuant�s datos desea introducir?'
	Leer numDatos
	Mientras numDatos<=0 Hacer
		Escribir 'N�mero no valido, escoja otro:'
		Leer numDatos
	FinMientras
	numBase <- numBase+numDatos
	Para variable<-numDatos Hasta 1 Con Paso -1 Hacer
		Escribir 'Introduzca un n�mero:'
		Leer numIn
		numSuma <- numSuma+numIn
		//Escribir numSuma
	FinPara
	numSuma <- numSuma/numBase
	Escribir 'La media resulta en: ', numSuma
FinAlgoritmo
