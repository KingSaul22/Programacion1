Algoritmo Ejer3b
	Escribir 'Introduzca la cantidad de n�meros que desea indicar:'
	Leer numP
	Mientras numP<=0 Hacer
		Escribir 'Cantidad erronea, pruebe de nuevo:'
		Leer numP
	FinMientras
	Escribir 'A continuaci�n podr� introducir un n�mero y se le indicar� si es par o impar.'
	Repetir
		Escribir 'Introduzca un n�mero:'
		Leer numA
		Si numA % 2 = entero Entonces
			Escribir numA ' es par' 
		SiNo
			Escribir numA ' es impar'
		FinSi
		numP = numP - 1
	Hasta Que numP = 0
FinAlgoritmo
