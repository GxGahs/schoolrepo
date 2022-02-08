#include <stdio.h>
int main (int argc, char* argv[]) {

	double array[5];
	double* int1;
	double* int2;

	int1 = (double*)&array;
	int2 = int1;
	int1++;



	int size = (int)int1 - (int)int2;


	printf("%i", size);

}
