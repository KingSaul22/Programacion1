Algoritmo Ejer10
	Escribir 'Entregue un número entero positivo:'
	Leer num
	numR <- num
	numR <- redon(numR)-num
	// numR <- numR-num
	// Escribir num ' y ' numR
	Mientras num<0 O numR<>0 Hacer
		Escribir 'Número no valido, introduzca otro número: '
		Leer num
		numR <- num
		numR <- redon(numR)-num
		// numR <- numR-num
	FinMientras
	numBase <- num
	Si num > 1 Entonces
		total <- num
		Para num<-num - 1 Hasta 2 Con Paso -1 Hacer
			total = total * num
		FinPara
	SiNo
		total <- 1
	FinSi
	Escribir 'El factorial de ' numBase ' es: ' total
FinAlgoritmo
