Algoritmo Ejer9
	Escribir 'Entregue un número entero positivo:'
	Leer num
	numR <- redon(num)-num
	Mientras num<0 O numR<>0 Hacer
		Escribir 'Número no valido, introduzca otro número: '
		Leer num
		numR <- redon(num)-num
	FinMientras
	numL = (redon(num) / 2) + 1
	rslt <- 0
	Para divisor<-1 Hasta numL Con Paso 1 Hacer
		numB <- num MOD divisor
		Si numB=0 Entonces
			rslt <- rslt + divisor
		FinSi
	FinPara
	Si rslt=num Entonces
		Escribir num, ' es un número perfecto'
	SiNo
		Escribir num, ' no es un número perfecto'
	FinSi
FinAlgoritmo
