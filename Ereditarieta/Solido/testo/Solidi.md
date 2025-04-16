# Solido

## Prima Parte
Realizzare una classe astratta `Solido` con attributo `pesoSpecifico` (che rappresenta la massa per unità di volume) e metodi astratti di `volume` e `superficie`, creare un inoltre il metodo per il calcolo del peso (inteso come massa).

Derivare dalla classe `Solido` due classi: `Sfera` e `Cubo` che devono essere classi concrete (non astratte)

Creare una classe `Test` che realizzi un menu di scelta fatto in questo modo

	MENU - SCELTA CALCOLO
	1) Calcolo del volume
	2) Calcolo della superficie
	
una volta che l'utente ha fatto la scelta gli appare un altro menu che indica il solido

	MENU - SCELTA SOLIDO
	1) SFERA 
	2) CUBO

A seconda delle scelte fatte viene chiamato il metodo opportuno per il corretto calcolo il cui risultato viene mostrato a schermo.