#include "file.h"

int contaRighe(FILE*ftxt) {
	int dim=1, i;
	i=fgetc(ftxt);
	do {
		if (i==10)
			dim++;
		i=fgetc(ftxt);
	}
	while (i!=EOF);
	return dim;
}

int contaParole(FILE*ftxt) {
	int dim=0, i=0;
	do {
		i=fscanf(ftxt, "%s");
		if (i>0)
			dim= dim+i;
	}
	while (i!=EOF);
	return dim;
}

int contaCaratteri(FILE*ftxt) {
	int dim=0, i;
	char ch=EOF;
	do {
		i=fscanf(ftxt, "%c", &ch);
		if (ch != EOF && i==1)
			dim= dim+i;
	}
	while (ch!=EOF && i==1);
	return dim;
}

int binRan(FILE*f) {
	int i, n;
	for(i=0; i<RAND; i++) {
		n= (rand()%200);
		fwrite(&n, sizeof(int), 1, f);
	}
	return i;
}

int readField(FILE*f, char*el, char sep) {
	char t;
	int i=0;
	while ((t =fgetc(f))!=sep && t!=EOF && t!=10) {
		el[i]=t;
		i++;
	}
	el[i]= '\0';
	return t;
}
