#include "elementList.h"

void readL(ElementList *el) {
	scanf("%d", el);
}
/* SE STRINGA:
scanf("%s", *el);
ALTRIMENTI scanf("%d", el);
*/








int printL(ElementList*el) {
	int n;
	n= printf("%d", *el);
	return n;
}
/* SE STRINGA n= printf("%s", *el);
ALTRIMENTI n= printf("%d", *el);
*/




int compareL(ElementList a, ElementList b) {
	if (a<b)
		return -1;
	else if (a==b)
		return 0;
	else 
		return 1;
}
/*SE STRINGA return strcmp(a, b);
ALTRIMENTI 	if (a<b)
		return -1;
	else if (a==b)
		return 0;
	else 
		return 1;
*/

void cpyelL(ElementList *a, ElementList b) {
	*a=b;
}
// SE STRINGA  strcpy(*a, b);
//ALTRIMENTI  *a=b;


Boolean equalsL(ElementList el1, ElementList el2) {
	return (el1==el2)? True:False;
}
/*SE STRINGA 
	return strcmp(el1, el2)? False:True;
ALTRIMENTI 
	return (el1==el2)? True:False;
*/