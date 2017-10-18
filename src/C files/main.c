#include "collatzAlgorithm.h"

int main()
{
	unsigned long n=1;
	list sequence = emptyList();
		
	while(n!=0) 
	{
		printf("Welcome! We will test Collatz conjecture here!\nIf you want to exit press 0\nPlease insert a natural number different from 0:\t");
		scanf("%lu", &n);
		while (n!=0 && n<0)
		{
			printf("----Number not valid: please retry:\t");
			scanf("/t%lu", &n);
		}
		if (n!=0) 
		{
			sequence=emptyList();
			printf("\t%lu\n", collatzWithPrints(n));
			printf("\n\tt= %lu\n\n", stepFunction(n));
			printf("\t");
			sequence = stepSequence(n, sequence);
			printStepSequence(sequence, "nodes.txt");
			printAllEdges(sequence, "edgesWithREPETITIONS.txt"); 
			/*showList(sequence);
			printf("\n\n");
			printf("\n\n");*/
			freeList(sequence);
		}
	}
	system("PAUSE");
	return 0;
}
