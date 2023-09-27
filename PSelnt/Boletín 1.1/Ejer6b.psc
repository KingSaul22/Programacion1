Algoritmo Ejer6b
	Escribir 'Introduzca el primer número:'
	Leer num1
	Escribir 'Introduzca el segundo número:'
	Leer num2
	Si num1=0 O num2=0 Entonces
		rslt <- 0
	SiNo
		Si num1>0 Y num2>0 Entonces
			// Positivo
			Mientras num2>0 Hacer
				num2 <- num2-1
				rslt <- rslt+num1
			FinMientras
		SiNo
			Si num1>0 O num2>0 Entonces
				// Negativo
				Si num1 > 0 Entonces
					Mientras num2<0 Hacer
						num2 <- num2+1
						rslt <- rslt-num1
					FinMientras
				SiNo
					Mientras num2>0 Hacer
						num2 = num2 -1
						rslt = rslt + num1
					FinMientras
				FinSi
			SiNo
				// Positivo
				Mientras num2<0 Hacer
					num2 <- num2+1
					rslt <- rslt+num1
				FinMientras
				rslt <- -rslt
			FinSi
		FinSi
	FinSi
	Escribir 'El total es: ', rslt
FinAlgoritmo
