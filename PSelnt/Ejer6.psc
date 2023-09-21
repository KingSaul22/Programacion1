Algoritmo Ejer6
	Escribir 'Introduzca el primer número:'
	Leer num1
	Escribir 'Introduzca el segundo número:'
	Leer num2
	Si num1=0 O num2=0 Entonces
		rslt <- 0
	SiNo
		rslt <- 0
		Si num1>0 Y num2>0 Entonces
			// Positivos
			Mientras num2>0 Hacer
				num2 <- num2-1
				rslt <- rslt+num1
			FinMientras
		SiNo
			Si num1>0 O num2>0 Entonces
				// Negativos
				num1 <- abs(num1)
				num2 <- abs(num2)
				Mientras num2>0 Hacer
					num2 <- num2-1
					rslt <- rslt+num1
				FinMientras
				rslt <- -rslt
			SiNo
				// Positivos
				num1 <- -num1
				num2 <- -num2
				Mientras num2>0 Hacer
					num2 <- num2-1
					rslt <- rslt+num1
				FinMientras
			FinSi
		FinSi
	FinSi
	Escribir 'El total es: ', rslt
FinAlgoritmo
