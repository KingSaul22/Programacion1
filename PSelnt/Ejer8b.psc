Algoritmo Ejer8b
	Escribir 'Cantidad de números que desea incluir:'
	Leer base
	Mientras base <= 0 Hacer
		Escribir 'Número no valido, introduzca uno positivo'
		Leer base
	FinMientras
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
	Leer resp
	Mientras resp<>'S' Y resp<>'N' Y resp<>'s' Y resp<>'n' Hacer
		Escribir 'Respuesta no valida, responda con S o N'
		Leer resp
	FinMientras
	Si resp='S' O resp='s' Entonces
		Repetir
			Escribir 'Introduzca otro número:'
			Leer numB
			Si numA>numB Entonces
				numA <- numB
			FinSi
			Escribir '¿Desea añadir más números? Conteste con S o N'
			Leer resp
		Hasta Que resp='n' O resp='N'
	FinSi
	Escribir 'El número más pequeño que ha  escrito es: ' numA
FinAlgoritmo
