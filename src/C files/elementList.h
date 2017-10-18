/*
LORENZO ROSA
Matricola 0000718690
Ingegneria Informatica
Numero prova:

Questa libreria include la definizione di un tipo per le LISTE
				(vedi ElementDEF.H)
								e le sue principali funzioni:
1) LEGGI
2) STAMPA
3) CONFRONTA

Per modificare un tipo, modificare:
1) Il typedef;
2) Il contenuto delle printf e delle scanf;
3) Gli operatori di relazione d'ordine, es. per le stringhe sostituire "<=>" con strcmp!!!
*/
#ifndef _ELEMENTLIST_H
#define _ELEMENTLIST_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "elementdef.h"

#define ERROR ZERO

void readL(ElementList *el); //Legge un Elemento e lo alloca in "el"
int printL(ElementList*el); //Stampa un Elemento, restituisce il numero di campi stampati;
int compareL(ElementList a, ElementList b); //Restituisce -1 se a<b; 0 se a==b; 1 se a>b;
void cpyelL(ElementList *a, ElementList b); //COPIA di un Elemento in un altro (assegnamento) "="
Boolean equalsL(ElementList el1, ElementList el2); //Test di uguaglianza;

#endif /* _ELEMENTLIST_H */