Algoritmo Ejer1b
	Escribir 'Introduzca un n�mero m�ximo:'
	Leer max
	Escribir 'Escriba un n�mero:'
	Leer numA
	Escribir 'Escriba otro n�mero:'
	Leer numB
	Si max > 0 Entonces
		numInm <- 1
	SiNo
		numInm <- -1
	FinSi
	Para base<-1 Hasta max Con Paso numInm Hacer
		Si base MOD numA=entero Entonces
			Escribir base, ' es divisible por ', numA
			Si base MOD numB=entero Entonces
				Escribir base, ' tambi�n es divisible por ', numB
			FinSi
		SiNo
			Si base MOD numB=entero Entonces
				Escribir base, ', solo es divisible por ', numB
			FinSi
		FinSi
	FinPara
FinAlgoritmo
