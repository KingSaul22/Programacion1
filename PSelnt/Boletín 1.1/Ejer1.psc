Algoritmo Ejer1
	Escribir 'Introduzca un n�mero m�ximo:'
	Leer max
	Escribir 'Escriba un n�mero:'
	Leer numA
	Escribir 'Escriba otro n�mero:'
	Leer numB
	base <- 1
	Repetir
		Si base MOD numA=0 Entonces
			Si base MOD numB=0 Entonces
				Escribir base, ' es divisible por ', numA, ', tambi�n es divisible por ', numB
			SiNo
				Escribir base, ' solo es divisible por ', numA
			FinSi
		SiNo
			Si base MOD numB=0 Entonces
				Escribir base, ', solo es divisible por ', numB
			FinSi
		FinSi
		base <- base+1
	Hasta Que base>=max+1
FinAlgoritmo
