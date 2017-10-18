/*
LORENZO ROSA
Matricola: 0000718690
Numero prova: 

Libreria sulle liste.

TIPO: la definizione di tipo, e tutte le sue funzioni
	-stampa;
	-leggi;
	-confronta;
	ecc.;
è contenuta nell'header "elementdef.h"
*/

#ifndef _LIST_H
#define _LIST_H
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ElementList.h"
#include "file.h"

typedef struct list_element {
	ElementList value;
	struct list_element *next;
} node;

typedef node *list;


//PRIMITIVE
list emptyList(void); //Costruisce una lista vuota
Boolean empty(list l); //Predica la pienezza della lista (True=vuota, False=non vuota);
ElementList head(list l); //Restituisce il primo elemento della lista;
list tail(list l); //Elimina il primo elemento della lista restituendo un puntatore al secondo;
list cons(ElementList el, list l); //Inserisce un elemento alla lista(alla fine);

//MOLTO UTILI
void freeList(list l); //FREE della lista;
ElementList getLast(list l); //Restituisce l'ultimo elemento della lista;

//LETTURA (da terminale o da file)
list letturaLista(list l); //Legge una lista da terminale e la restituisce;
list letturaListaOrd(list l); //Legge una lista da terminale e la restituisce ORDINATA!;
Boolean readFromFile(char*nameFile, list*l); //Legge una lista di STRUCT da FILE di testo, se si vuole la restituisce ordinata;

//STAMPA (su terminale, con la notazione a lista. Se non si tratta di numeri, togliere la notazione a lista)
void showList(list l); //Stampa a video gli elementi della lista;

//RICERCA di un elemento
Boolean member(ElementList el, list l); //Predica la presenza("True") o l'assenza("False") di un elemento nella lista;
Boolean findEl(list l, int index, ElementList*elem); //Mette in elem l'elemento in posizione index, restituisce False se non esiste la posizione index;
ElementList select(list l, int index); //Restituisce l'elemento in posizione index;
list subList(int n, list l); //Restituisce un puntatore all' n-esimo elemento della lista;
ElementList findMax(list l); //Trova l'elemento massimo di una lista;
int findMaxIndex(list l); //Trova l'INDICE(non la posizione, l'indice) in cui si trova l'elemento massimo;
int contaValList(list l, ElementList el); //Conta quante volte un elemento è presente nella lista (usa EQUAL, non compare);
int elements(list l); //Conta quanti elementi sono presenti nella lista;

//CONCATENAZIONE, INVERSIONE, COPIA, INTERSEZIONE, PULIZIA, ECC..
list intersect(list l1, list l2); //Intersezione tra due liste. STR SHARING!
list reverse(list l); //Restituisce una nuova lista, rovesciata;
list diff(list l1, list l2); //restituisce una lista contenente i valori presenti in l1 che NON sono presenti in l2
list append(list dest, list source); //Concatena due liste. STRSHR, soprattutto se la prima è vuota;
list copyList(list l); //Copia una lista in un'altra, NO STRSHR;
list eliminaRipetuti(list l); // Elimina gli elementi ripetuti. Usa "insord", quindi STRSHR.
list deleteEl(list source, ElementList el); //Elimina un elemento dalla lista (CONTROLLARE FREE);


//ORDINAMENTO
list insord(list l, ElementList el); //Inserisce un elemento in una lista ORDINATA. Dal punto di inserimento in poi STRSHR;
list insord2(list l, ElementList el); //Come sopra, ma senza primitive o ADT.
list ordinaLista(list l); //Data una lista, la restituisce ordinata.(Utilizza insord, restituisce una nuova lista in parziale STRSHR!);

#endif /* _LIST_H */