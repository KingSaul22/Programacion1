Algoritmo Ejer10
	Escribir 'Seleccione un animal entre: Sapo, Lechuza, Gato'
	Leer animal
	Escribir 'Seleccione un color: Azul, Rojo, Verde, Amarillo'
	Leer color
	Escribir 'Seleccione una asignatura: Encantamientos, Herbolog�a, Pociones'
	Leer asig
	Seg�n animal Hacer
		'Gato':
			sly = sly + 4
		'Sapo':
			huff = huff + 4
		De Otro Modo:
			rav = rav + 4
	FinSeg�n
	Seg�n color Hacer
		'Azul':
			rav = rav +2
		'Rojo':
			gry = gry + 2
		'Verde':
			sly = sly + 2
		De Otro Modo:
			huff = huff + 2
	FinSeg�n
	Seg�n asig Hacer
		'Encantamientos':
			rav = rav + 5
		'Pociones':
			gry = gry + 5
		De Otro Modo:
			huff = huff + 5
	FinSeg�n
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
	Seg�n casa Hacer
		gry:
			casaP <- 'Gryffindor'
		huff:
			casaP <- 'Hyfflepuff'
		sly:
			casaP <- 'Slytherin'
		De Otro Modo:
			casaP <- 'Ravenclaw'
	FinSeg�n
	Escribir 'Casa correspondiente: ', casaP
FinAlgoritmo
