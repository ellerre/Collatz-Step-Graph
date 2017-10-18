/*
LORENZO ROSA
Matricola: 0000718690

Collegio Superiore

Definizione del tipo generico "ElementArray".
Definizione del tipo generico "ElementList".
Definizione del tipo "Boolean".

Ogni volta che si cambia, ricordare di cambiare le funzioni primitive nei file
																			"ELEMENTARRAY.C"/"ELEMENTLIST.C".
*/

#ifndef _ELEMENTDEF_H
#define _ELEMENTDEF_H

typedef int ElementArray;
typedef unsigned int ElementList;


#define ZERO 0 //SE IL TIPO è un puntatore, mettere "0", altrimenti 0.
/*
#define DIM 35 //LUNGHEZZA DI UNA STRINGA. Se il tipo non è " char* ", mettere 1;
#define DIM_ARRAY 10
*/

#ifndef BOOLEAN
#define BOOLEAN
typedef enum Boolean {False, True} Boolean;
#endif /* BOOLEAN */

#endif /* _ELEMENTDEF_H */