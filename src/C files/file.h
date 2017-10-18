#ifndef _FILE_H
#define _FILE_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define RAND 50

/* 	FILE*f;
	if((f=fopen(NAME, "r"))==NULL)
	exit(1);
	*/

int contaRighe(FILE*ftxt);
int contaParole(FILE*ftxt);
int contaCaratteri(FILE*ftxt);
int binRan(FILE*f);
int readField(FILE*f, char*el, char sep);

#endif /* _FILE_H */