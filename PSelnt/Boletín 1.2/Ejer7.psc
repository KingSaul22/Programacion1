Algoritmo Ejer7
	Escribir 'Tipo de pokémon favorito'
	Leer pok
	Según pok Hacer
		'fuego':
			sugg <- 'Charmander'
		'agua':
			sugg <- 'Squirtle'
		'planta':
			sugg <- 'Bulbasur'
		De Otro Modo:
			sugg <- '~~~~~~~~~ tipo de pokémon no reconocido, intente de nuevo'
	FinSegún
	Escribir 'El pokémon recomendado es: ' sugg
FinAlgoritmo
