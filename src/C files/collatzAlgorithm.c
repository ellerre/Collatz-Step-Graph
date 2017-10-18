#include "collatzAlgorithm.h"

static unsigned long t=0;

unsigned long collatz(unsigned long n)
{
	while (n!=1) {
			t++;
			if ((n%2)!=0) 
				n= 3*n+1;
			else n=n/2;
		}
		return n;
}

unsigned long collatzWithPrints(unsigned long n) 
{
	while (n!=1) {
			t++;
			printf("\t%lu\n", n);
			if ((n%2)!=0) 
				n= 3*n+1;
			else n=n/2;
	}
	return n;
}

unsigned long stepFunction(unsigned long n) 
{
	t=0;
	collatz(n);
	return t;
}

list stepSequence(unsigned long n, list sequence)
{
	if (!empty(sequence))
		return NULL;
	else 
	{
		unsigned long index = n;
		while (index>1)
			sequence =cons(stepFunction(index--) , sequence);
		return sequence;
	}
}

void printStepSequence(list sequence, char*fileName)
{
	int index =0;
	FILE* fp;
	if ((fp=fopen(fileName, "w")) == NULL) {                    //OPENING FILE
 		printf("Error while opening file %s.\n\n", fileName);
 		system("PAUSE");
 		exit(-1); 
	}
	
	if (empty(sequence))
		printf("\nnessun elemento individuato\n");
	else {
		index = elements(sequence);
		while (!empty(sequence) && index>1)
		{
			fprintf(fp, "%u\n", (sequence->value));
			sequence=sequence->next;
			index--;
		}
	}
	
	fclose(fp);
}

void printAllEdges(list sequence, char*fileName) 
{
	int index =0;
	FILE* fp;
	if ((fp=fopen(fileName, "w")) == NULL) {                    //OPENING FILE
 		printf("Error while opening file %s.\n\n", fileName);
 		system("PAUSE");
 		exit(-1); 
	}
	
	if (empty(sequence))
		printf("\nnessun elemento individuato\n");
	else {
		index = elements(sequence);
		while (!empty(sequence) && index>1)
		{
			if (!(sequence->next)==NULL)
			{
				fprintf(fp, "%u,%u,1.0\n", sequence->value, sequence->next->value);
				sequence=sequence->next;
				index--;
			}
			
		}
	}
	
	fclose(fp);
}