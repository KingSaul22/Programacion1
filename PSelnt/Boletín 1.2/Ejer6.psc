Algoritmo Ejer6
	Escribir 'Introduce el tipo de vehículo'
	Leer vehi
	Según vehi Hacer
		'camión':
			vel <- 80
		'moto':
			vel <- 90
		'coche':
			vel <- 120
		De Otro Modo:
			Escribir 'No reconozco ese vehículo'
	FinSegún
FinAlgoritmo
