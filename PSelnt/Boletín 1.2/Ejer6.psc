Algoritmo Ejer6
	Escribir 'Introduce el tipo de veh�culo'
	Leer vehi
	Seg�n vehi Hacer
		'cami�n':
			vel <- 80
		'moto':
			vel <- 90
		'coche':
			vel <- 120
		De Otro Modo:
			Escribir 'No reconozco ese veh�culo'
	FinSeg�n
FinAlgoritmo
