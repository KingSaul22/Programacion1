Algoritmo Ejer9
	Escribir 'Entregue un n�mero entero positivo:'
	Leer num
	numR <- redon(num)-num
	Mientras num<0 O numR<>0 Hacer
		Escribir 'N�mero no valido, introduzca otro n�mero: '
		Leer num
		numR <- redon(num)-num
	FinMientras
	// Escribir num, ' es entero y positivo'
	rslt <- 0
	numCalc = num - 1
	Para divisor<-numCalc Hasta 1 Con Paso -1 Hacer
		numB = num / divisor
		numBR <- redon(numB)-num
		Si divisorR=0 Entonces
			rslt <- rslt+numB
		FinSi
	FinPara
	Escribir rslt ' Y ' num
	Si rslt=num Entonces
		Escribir num, ' es un n�mero perfecto'
	SiNo
		Escribir num, ' no es un n�mero perfecto'
	FinSi
FinAlgoritmo
