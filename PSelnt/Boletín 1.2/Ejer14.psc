Algoritmo Ejer14
	Escribir 'Escriba un número'
	Leer num1
	Escribir 'Escriba un segundo número'
	Leer num2
	Escribir 'Seleccione Suma, Resta, División o Multiplicación'
	Leer oper
	Según oper Hacer
		'Suma':
			Escribir num1+num2
		'Resta':
			Escribir num1-num2
		'División':
			Escribir num1/num2
		'Multiplicación':
			Escribir num1*num2
		De Otro Modo:
			Escribir 'Retrasado'
	FinSegún
FinAlgoritmo
