Algoritmo Ejer3c
	Escribir 'Introduzca la cantidad de n�meros que desea indicar:'
	Leer numP
	Mientras numP<=0 Hacer
		Escribir 'Cantidad erronea, pruebe de nuevo:'
		Leer numP
	FinMientras
	Escribir 'A continuaci�n podr� introducir un n�mero y se le indicar� si es par o impar.'
	Para variable<-numP Hasta 1 Con Paso -1 Hacer
		Escribir 'Introduzca un n�mero:'
		Leer numA
		Si numA MOD 2=entero Entonces
			Escribir numA, ' es par'
		SiNo
			Escribir numA, ' es impar'
		FinSi
	FinPara
FinAlgoritmo
