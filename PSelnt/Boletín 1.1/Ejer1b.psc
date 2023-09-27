Algoritmo Ejer1b
	Escribir 'Introduzca un número máximo:'
	Leer max
	Escribir 'Escriba un número:'
	Leer numA
	Escribir 'Escriba otro número:'
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
				Escribir base, ' también es divisible por ', numB
			FinSi
		SiNo
			Si base MOD numB=entero Entonces
				Escribir base, ', solo es divisible por ', numB
			FinSi
		FinSi
	FinPara
FinAlgoritmo
