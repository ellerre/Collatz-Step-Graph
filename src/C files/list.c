#include "list.h"

Boolean empty(list l) {
	return (l==NULL)? True:False;
}
list emptyList(void) {
	return NULL;
}
ElementList head(list l) {
	if (empty(l))
		abort();
	else return l->value;
}
list tail(list l) {
	if (empty(l)) 
		abort();
	else 
		return l=l->next;
}
list cons(ElementList el, list l) {
	list t;
	t = (list)malloc(sizeof(node));
	cpyelL(&t->value, el);
	t->next = l;
	return t; 
}
void freeList(list l) {
	list temp;
	while(!empty(l)) {
	temp = l;
	l = tail(l);
	free(temp);
	}
}
ElementList getLast(list l) {
	if(empty(l))
		abort();
	else if(l->next==NULL)
		return l->value;
	else return getLast(tail(l));
}
/*
list letturaLista(list l) {
	int flag;
	ElementList n;
	printf("Inserire i valori. Per terminare prima, inserire 0.\n");
	do	{
		printf("Inserire il prossimo valore: ");
		readL(&n);
		if (!compareL(n, ZERO))
			flag=0;
		else {
			l= cons(n, l);
			flag=1;
		}
	}
	while (flag!=0);
	return l;
}
list letturaListaOrd(list l) {
	int flag;
	ElementList n;
	printf("Inserire i valori. Per terminare prima, inserire 0.\n");
	do	{
		printf("Inserire il prossimo valore: ");
		readL(&n);
		if (!compareL(n, ZERO))
			flag=0;
		else {
			l= insord(l, n);
			flag=1;
		}
	}
	while (flag!=0);
	return l;
}

#ifdef STRUCT
Boolean readFromFile(char*nameFile, list*l) { //Possibilità 1: usare la "readField" (file.h); Possibilità 2: usare fscanf. Qui si usa la readField.
	FILE*f;
	ElementList temp;
	*l=emptyList();
	if ((fp=fopen(fileName, "r")) == NULL) {                    //APERTURA FILE
 		printf("Errore nell'apertura del file %s.\n\n", fileName);
 		system("PAUSE");
 		return False 
	}
	while(readField(f, &(temp.CAMPO), ';')>0) {//SEPARATORE DA CAMBIARE a seconda dell'esercizio dato
		
		//ReadField finchè serve per riempire i campi della struct
		
		*l=cons(temp, *l); //Insord, se serve una lista ordinata;
		return True;
	}
}

#endif
*/
void showList(list l) {
	int index =0;
	if (empty(l))
		printf("\nnessun elemento individuato\n");
	else {
		printf("[");
		index = elements(l);
		while (!empty(l) && index>1)
		{
			printL(&(l->value));
			printf(", ");
			l=l->next;
			index--;
		}
		printL(&(l->value));
		printf("]");
	}
}

Boolean member(ElementList el, list l) {
	Boolean trovato = False;
	if (empty(l))
		return trovato;
	if (compareL(l->value, el)) 
		trovato = True;
	else if (member(el, l->next)==1)
		trovato=True;
	return trovato;
}
Boolean findEl(list l, int index, ElementList*elem){
	int i=0, flag=0;
	list tmp=l;
	while (i<index && flag==0) {
		tmp=tmp->next;
		if (empty(tmp))
			flag=1;
		i++;
	}
	if (flag==1)
		return False;
	else {
		*elem=tmp->value;
		return True;
	}
} 
ElementList select(list l, int index) {
	if (empty(l))
		abort();
	if (index==0)
		return head(l);
	else 
		return select(tail(l), index-1);
}
list subList(int n, list l) {
	int i=0, flag=0;
	if (empty(l))
		abort();
	while (i<n && flag==0) {
		l=l->next;
		if (empty(l)==True)
			flag=1;
		i++;
	}
	return l;
}
ElementList findMax(list l) {
	ElementList max;
	if (empty(l))
		abort();
	else {
		cpyelL(&max, head(l));
		l=tail(l);
		while (!empty(l)) {
			if (compareL(max, head(l))<0)
				cpyelL(&max, head(l));
			l=tail(l);
		}
		return max;
	}
}
int findMaxIndex(list l) {
	ElementList max;
	int index=0, maxIndex;
	if (empty(l))
		abort();
	else {
		cpyelL(&max, head(l));
		l=tail(l);
		index++;
		while (!empty(l)) {
			if (compareL(max, head(l))<0) {
				cpyelL(&max, head(l));
				maxIndex=index;
			}
			index++;
			l=tail(l);
		}
		return maxIndex;
	}
}
int contaValList(list l, ElementList el) {
	int count=0;
	while(!empty(l)) {
		if (equalsL(head(l), el))
			count++;
		l=tail(l);
	}
	return count;
}
int elements(list l) {
	int n=0;
	while(!empty(l)) {
		n++;
		l=tail(l);
	}
	return n;
}

list intersect(list l1, list l2) {
	list ints=emptyList();
	if(empty(l1) || empty(l2))
		return ints;
	while (!empty(l1)) {
		if (member(l1->value, l2)==True && member(l1->value, ints)==True) {
			ints= cons(l1->value, ints);
			l1= tail(l1);
		}
	}
	return ints;
}
list reverse(list l) {
	if (empty(l))
		return emptyList();
	else 
		return append(reverse(tail(l)), cons(head(l), emptyList()));
}
list diff(list l1, list l2) {
	list diff=emptyList();
	if(empty(l1) || empty(l2))
		return l1;
	while (!empty(l1)) {
		if (member(l1->value, l2)==False && member(l1->value, diff)==False) {
			diff= cons(l1->value, diff);
		}
		l1= tail(l1);
	}
	return diff;
}
list append(list dest, list source) {
	if (empty(dest))
		return source;
	else return cons(head(dest), append(tail(dest), source));
}
list copyList(list l) {
	if (empty(l))
		return l;
	else return cons(head(l), tail(l));
}
list eliminaRipetuti(list l) {
	list result=emptyList();
	list ordinata=emptyList();
	list temp=emptyList();
	temp=l;
	while(!empty(temp)) {
		ordinata=insord(ordinata, head(temp));
		temp=tail(temp);
	}
	while(!empty(ordinata)) {
		if(!member(head(ordinata), tail(ordinata)))
			result= insord(result, head(ordinata));
		ordinata=tail(ordinata);
	}
	result=copyList(result);
	freeList(ordinata);
	freeList(temp);
	return result;
}
list deleteEl(list source, ElementList el) {
	if (empty(source))
		return emptyList();
	else if(equalsL(head(source), el))
		return tail(source);
	else 
		return cons(head(source), deleteEl(tail(source), el));
}

list insord(list l, ElementList el) {
	if (empty(l))
		return cons(el, l);
	else if (compareL(head(l), el)>=0)
		return cons(el, l);
	else return cons(head(l), insord(tail(l), el));
}
list insord2(list l, ElementList el) {
	list t;
	if(l==NULL) {
		l=(list)malloc(sizeof(node));
		cpyelL(&l->value, el);
		l->next=NULL;
		return l;
	}
	else if(compareL(l->value, el)>=0) {
		t=(list)malloc(sizeof(node));
		cpyelL(&t->value, el);
		t->next=l;
		return t;
	}
	else {
		t=(list)malloc(sizeof(node));
		cpyelL(&t->value, l->value);
		t->next=insord2(l->next, el);
		return t;
	}
}












list ordinaLista(list l) {
	list temp=emptyList();
	while (!empty(l)) { 
	temp = insord(temp, head(l)); //TEMP è una lista temporanea
	l = tail(l);
	}
	return temp;
}


		
