Algoritmo Ejer8b
	Escribir 'Cantidad de n�meros que desea incluir:'
	Leer base
	Mientras base <= 0 Hacer
		Escribir 'N�mero no valido, introduzca uno positivo'
		Leer base
	FinMientras
	baseCopy <- base
	Escribir 'Introduzca un n�mero'
	Leer numA
	base <- base-1
	Mientras base>0 Hacer
		Escribir 'Introduzca otro n�mero'
		Leer numB
		Si numA>numB Entonces
			numA <- numB
		FinSi
		base <- base-1
	FinMientras
	Escribir '�Desea a�adir m�s n�meros? Conteste con S o N'
	Leer resp
	Mientras resp<>'S' Y resp<>'N' Y resp<>'s' Y resp<>'n' Hacer
		Escribir 'Respuesta no valida, responda con S o N'
		Leer resp
	FinMientras
	Si resp='S' O resp='s' Entonces
		Repetir
			Escribir 'Introduzca otro n�mero:'
			Leer numB
			Si numA>numB Entonces
				numA <- numB
			FinSi
			Escribir '�Desea a�adir m�s n�meros? Conteste con S o N'
			Leer resp
		Hasta Que resp='n' O resp='N'
	FinSi
	Escribir 'El n�mero m�s peque�o que ha  escrito es: ' numA
FinAlgoritmo
