Algoritmo Ejer1
	Escribir 'Introduzca un número máximo:'
	Leer max
	Escribir 'Escriba un número:'
	Leer numA
	Escribir 'Escriba otro número:'
	Leer numB
	base <- 1
	Repetir
		Si base % numA = entero Entonces
			Escribir base, ' es divisible por ', numA
			Si base % numB = entero Entonces
				Escribir base ' también es divisible por ', numB
			FinSi
		SiNo
			Si base % numB = entero Entonces
				Escribir base ', solo es divisible por ', numB
			FinSi
		FinSi
		base <- base+1
	Hasta Que base>=max+1
FinAlgoritmo
