Algoritmo Ejer8b
	Escribir 'Cantidad de n�meros que desea incluir:'
	Leer base
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
	Mientras resp<>S O n Hacer
		Escribir 'Respuesta no valida, responda con S o N'
		Leer resp
	FinMientras
	Repetir
		Leer resp
	Hasta Que resp=n O n
FinAlgoritmo
