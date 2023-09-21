Algoritmo Ejer2
	Escribir 'Escriba un número comprendido entre 0 y 10'
	Leer num
	Escribir 'La tabla del ' num ' es la siguiente:'
	base <- 0
	Repetir
		rslt = num * base
		Escribir num '*' base ' = ' rslt
		base = base + 1
	Hasta Que base = 11
FinAlgoritmo
