Algoritmo Ejer7
	Escribir 'Tipo de pok�mon favorito'
	Leer pok
	Seg�n pok Hacer
		'fuego':
			sugg <- 'Charmander'
		'agua':
			sugg <- 'Squirtle'
		'planta':
			sugg <- 'Bulbasur'
		De Otro Modo:
			sugg <- '~~~~~~~~~ tipo de pok�mon no reconocido, intente de nuevo'
	FinSeg�n
	Escribir 'El pok�mon recomendado es: ' sugg
FinAlgoritmo
