Algoritmo Ejer10
	Escribir 'Seleccione un animal entre: Sapo, Lechuza, Gato'
	Leer animal
	Escribir 'Seleccione un color: Azul, Rojo, Verde, Amarillo'
	Leer color
	Escribir 'Seleccione una asignatura: Encantamientos, Herbología, Pociones'
	Leer asig
	Según animal Hacer
		'Gato':
			sly = sly + 4
		'Sapo':
			huff = huff + 4
		De Otro Modo:
			rav = rav + 4
	FinSegún
	Según color Hacer
		'Azul':
			rav = rav +2
		'Rojo':
			gry = gry + 2
		'Verde':
			sly = sly + 2
		De Otro Modo:
			huff = huff + 2
	FinSegún
	Según asig Hacer
		'Encantamientos':
			rav = rav + 5
		'Pociones':
			gry = gry + 5
		De Otro Modo:
			huff = huff + 5
	FinSegún
	Si rav > gry Entonces
		casa <- rav
	SiNo
		casa <- gry
	FinSi
	Si casa < sly Entonces
		casa <- sly
	FinSi
	Si casa < huff Entonces
		casa <- huff
	FinSi
	Según casa Hacer
		gry:
			casaP <- 'Gryffindor'
		huff:
			casaP <- 'Hyfflepuff'
		sly:
			casaP <- 'Slytherin'
		De Otro Modo:
			casaP <- 'Ravenclaw'
	FinSegún
	Escribir 'Casa correspondiente: ', casaP
FinAlgoritmo
