Algoritmo Ejer8
	Escribir 'Introduzca un n�mero'
	Leer numA
	Escribir 'Introduzca otro n�mero'
	Leer numB
	Repetir
		Si numA>numB Entonces
			numA <- numB
		FinSi
		Escribir '�Desea a�adir m�s n�meros? Conteste con S o N'
		Leer resp
		Mientras resp <> "S" o "N" Hacer
			Escribir 'Respuesta no valida, responda con S o N'
			Leer resp
		FinMientras
		Leer resp
	Hasta Que resp=N
FinAlgoritmo
