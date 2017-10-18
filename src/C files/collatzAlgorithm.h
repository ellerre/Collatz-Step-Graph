#ifndef _COLLATZALGORITHM_H
#define _COLLATZALGORITHM_H

#include <stdio.h>
#include "list.h"

#endif //_COLLATZALGORITHM_H

unsigned long collatz(unsigned long n); // Implements Collatz algorithm
unsigned long collatzWithPrints(unsigned long n); //As before, but printing the number n for each iteration
unsigned long stepFunction(unsigned long n); // Counts the number of iteration steps t it takes "collatz(n)" to map to 1
list stepSequence(unsigned long n, list sequence); //Create a list of n-1 elements; the value of element i is  "stepFunction(i)"
void printStepSequence(list sequence, char*fileName); //Prints the list on a file;
void printAllEdges(list sequence, char*fileName); //Prints all the edges (With repetitions)