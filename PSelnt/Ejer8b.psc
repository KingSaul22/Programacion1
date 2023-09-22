Algoritmo Ejer8b
	Escribir 'Cantidad de números que desea incluir:'
	Leer base
	baseCopy <- base
	Escribir 'Introduzca un número'
	Leer numA
	base <- base-1
	Mientras base>0 Hacer
		Escribir 'Introduzca otro número'
		Leer numB
		Si numA>numB Entonces
			numA <- numB
		FinSi
		base <- base-1
	FinMientras
	Escribir '¿Desea añadir más números? Conteste con S o N'
	Mientras resp<>S O n Hacer
		Escribir 'Respuesta no valida, responda con S o N'
		Leer resp
	FinMientras
	Repetir
		Leer resp
	Hasta Que resp=n O n
FinAlgoritmo
