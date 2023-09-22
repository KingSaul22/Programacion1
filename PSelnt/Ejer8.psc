Algoritmo Ejer8
	Escribir 'Introduzca un número'
	Leer numA
	Escribir 'Introduzca otro número'
	Leer numB
	Repetir
		Si numA>numB Entonces
			numA <- numB
		FinSi
		Escribir '¿Desea añadir más números? Conteste con S o N'
		Leer resp
		Mientras resp <> "S" o "N" Hacer
			Escribir 'Respuesta no valida, responda con S o N'
			Leer resp
		FinMientras
		Leer resp
	Hasta Que resp=N
FinAlgoritmo
