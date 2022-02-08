/*
 * pointer.c - Source file with your solutions to the Lab.
 *             This is the file you will hand in to your instructor.
 *
 * WARNING: Do not include the <stdio.h> header; it confuses the dlc
 * compiler. You can still use printf for debugging without including
 * <stdio.h>. The included file, "common.c" contains a function declaration
 * that should prevent a compiler warning. In general, it's not good practice
 * to ignore compiler warnings, but in this case it's OK.
 */

#ifndef COMMON_H
#include "common.h"
#endif

/*
 * Instructions to Students:
 *
 * STEP 1: Read the following instructions carefully.
 */

#if 0
You will provide your solution to this homework by
editing the collection of functions in this source file.

INTEGER CODING RULES:

  Replace the "return" statement in each function with one
  or more lines of C code that implements the function. Your code
  must conform to the following style:

  int Funct(arg1, arg2, ...) {
      /* brief description of how your implementation works */
      int var1 = Expr1;
      ...
      int varM = ExprM;

      varJ = ExprJ;
      ...
      varN = ExprN;
      return ExprR;
  }

  Each "Expr" is an expression using ONLY the following:
  1. Integer constants 0 through 255 (0xFF), inclusive. You are
     not allowed to use big constants such as 0xffffffff.
     However, you are allowed to combine constants to values greater
     than 255 or less than 0. e.g. 250 + 250 = 500, so long as
     the operator you are using to combine the constants is listed as
     "legal" at the top of the method you are writing.
  2. Function arguments and local variables (no global variables).
  3. Any operators listed as "allowed" at the top of the method you are writing.
  4. casting.

  Some of the problems restrict the set of allowed operators even further.
  Each "Expr" may consist of multiple operators. You are not restricted to
  one operator per line.

  You are expressly forbidden to:
  1. Use any control constructs such as if, do, while, for, switch, etc. (unless
     otherwise stated).
  2. Define or use any macros.
  3. Define any additional functions in this file.
  4. Call any functions (unless otherwise stated).
  5. Use any operators not "allowed" at the top of the method you are writing.

  You may assume that your machine:
  1. Uses 2s complement, 32-bit representations of integers.
  2. Performs right shifts arithmetically.
  3. Has *undefined* behavior when shifting by a negative amount or an amount
     greater than or equal to the number of bits in the value being shifted.
     e.g. For x >> n, shifts by n < 0 or n >= *size of x* are undefined
     e.g. if x is a 32-bit int, shifts by >= 32 bits are undefined
     Undefined means you do not know what result you will get from the operation.
#endif

/*
 * STEP 2: Modify the following functions according the coding rules.
 */

/*
 * Return the size of an integer in bytes.
 *
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *
 *   Unary integer operators: !
 *   Shorthand operators based on the above: ex. +=, *=, ++, --, eFDIStc.
 *
 * DISALLOWED:
 *   Pointer operators: [] (Array Indexing Operator)
 *   Binary integer operators: &, &&, |, ||, <, >, <<, >>, ==, !=, ^, /, %
 *   Unary integer operators: ~, -
 */
int intSize() {
  int intArray[10];
  int * intPtr1;
  int * intPtr2;
  // Write code to compute size of an integer.
	int c = 0;	
  
	//the difference btwn the addresses in terms of char sized(1 byte) element widths
	c = (char*)(intArray + 1) - (char*)(intArray);	
  return c;
}

/*
 * Return the size of a double in bytes.
 *
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *
 *   Unary integer operators: !
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *
 *   Unary integer operators: !
 *   Shorthand operators based on the above: ex. +=, *=, ++, --, etc.
 *
 * DISALLOWED:
 *   Pointer operators: [] (Array Indexing Operator)
 *   Binary integer operators: &, &&, |, ||, <, >, <<, >>, ==, !=, ^, /, %
 *   Unary integer operators: ~, -
 */
int doubleSize() {
  double doubArray[10];
  double * doubPtr1;
  double * doubPtr2;
  // Write code to compute size of a double.
	int c = 0;
  	

	//the difference btwn the addresses in terms of char sized(1 byte) element widths
	c = (char*)(doubArray + 1) - (char*)(doubArray);	

  return c;
}

/*
 * Return the size of a pointer in bytes.
 *
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *
 *   Unary integer operators: !
 *   Shorthand operators based on the above: ex. +=, *=, ++, --, etc.
 *
 * DISALLOWED:
 *   Pointer operators: [] (Array Indexing Operator)
 *   Binary integer operators: &, &&, |, ||, <, >, <<, >>, ==, !=, ^, /, %
 *   Unary integer operators: ~, -
 */
int pointerSize() {
  int * ptrArray[10];
  int ** ptrPtr1;
  int ** ptrPtr2;
  // Write code to compute size of a pointer.

	int c =0;	
	//the difference btwn the addresses in terms of char sized(1 byte) element widths
	c = (char*)(ptrArray + 1) - (char*)(ptrArray);	


  return c;
}

/*
 * Given pointers to two distinct variables write a function to swap the values
 * of said variables.
 *
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *
 *   Unary integer operators: !
 *   Shorthand operators based on the above: ex. +=, *=, ++, --, etc.
 *
 * DISALLOWED:
 *   Pointer operators: [] (Array Indexing Operator)
 *   Binary integer operators: &, &&, |, ||, <, >, <<, >>, ==, !=, ^, /, %
 *   Unary integer operators: ~, -
 */
void swapInts(int * ptr1, int * ptr2) {
  // Your code here
  // uhhhh idk just swap em kek
	int a = 0, b = 0;
	a = *ptr1;
	b = *ptr2;
	*ptr1 = b;
	*ptr2 = a;

}

/*
 * Modify intArray[5] to be the value 449 using only intArray and pointer arithmetic.
 * 
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *, <<, >>, ==, ^
 *   Unary integer operators: !, ~
 *   Shorthand operators based on the above: ex. +=, *=, ++, --, ~= etc.
 *
 * DISALLOWED:
 *   Pointer operators: [] (Array Indexing Operator)
 *   Binary integer operators: &, &&, |, ||, <, >, !=, /, %
 *   Unary integer operators: -
 */
int changeValue() {
  int intArray[10];
  int * intPtr1 = intArray;
  // Remember not to use constants greater than 255.
  // Remember to use * to dereference. You cannot use '[<index>]' syntax.
	
  	//construct our constant >:)
	int c = (50 << 3) + 49;
	//navigate to array location and slip the constant in there
	intPtr1 += 5;
	*intPtr1 = c;

  // replace the line below to use pointer arithmetic
  return intArray[5];
}

/*
 * Return 1 if the addresses stored in ptr1 and ptr2 are within the
 * *same* 64-byte aligned  block of memory. Check the spec for examples if you are
 * confused about what this means. Return zero otherwise.
 * Operators / and % and loops are NOT allowed.
 *
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *, <<, >>, ==, ^
 *   Unary integer operators: !, ~
 *   Shorthand operators based on the above: ex. <<=, *=, ++, --, etc.
 *
 * DISALLOWED:
 *   Pointer operators: [] (Array Indexing Operator)
 *   Binary integer operators: &, &&, |, ||, <, >, !=, /, %
 *   Unary integer operators: -
 */
int withinSameBlock(int * ptr1, int * ptr2) {
  // Your code here
	
	
	int bytes = (char*)ptr1 - (char*)ptr2;

	//divide the difference of the two locations by 64 to see if they fall in the same block
	bytes = bytes >> 6;

	
	
	return !bytes;
}

/*
 * Return 1 if ptr points to an element within the specified intArray, 0 otherwise.
 * Pointing anywhere in the array is fair game, ptr does not have to
 * point to the beginning of an element. Check the spec for examples if you are 
 * confused about what this method is determining.
 * size is the size of intArray in number of ints. Can assume size != 0.
 * Operators / and % and loops are NOT allowed.
 *
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *, <<, >>, ==, ^
 *   Unary integer operators: !, ~
 *   Shorthand operators based on the above: ex. <<=, *=, ++, --, etc.
 *
 * DISALLOWED:
 *   Pointer operators: [] (Array Indexing Operator)
 *   Binary integer operators: &, &&, |, ||, <, >, !=, /, %
 *   Unary integer operators: -
 */
int withinArray(int * intArray, int size, int * ptr) {
	int* bruh = 0;
	int within = 0;
	int negative = 0;
	//c will be negative if ptr is less than intArray start address
	int c = ptr - (int*)intArray; 
	negative = c;

	
	negative >>= 31;
	negative = ~negative;	
	//negative is zero if (ptr - intArray) is negative (ptr less than intArray)
	
	//bruh holds addr of last element of array
	bruh = intArray + size - 1;
	within = bruh - ptr;
	//if said last element is at a greater addr than ptr
	within >>= 31;
	within = ~within;
	
	//multiply bc you will get 0 if either within or negative is 0 (meaning ptr was out of range)
	within = (within * negative);
	within = !!within;

		
	return within;
}

/*
 * In C characters are are terminated by the null character ('\0')
 * given a pointer to the start of the string return the length of this string.
 * (The null character is not counted as part of the string length.)
 *
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *, ==, !=, <, >
 *   Unary integer operators: !
 *   Shorthand operators based on the above: ex. <<=, *=, ++, --, etc.
 *   Control constructs: for, while
 *
 * DISALLOWED:
 *   Pointer operators: [] (Array Indexing Operator)
 *   Binary integer operators: &, &&, |, ||, <<, >>, ^, /, %
 *   Unary integer operators: ~, -
 */
int stringLength(char * s) {
  // Your code here
  	int len = 0;
	char* iterator = 0;
	while (1) {
		//iterate over all character bytes until we reach null byte and thus
		//obtain the length
		iterator = s + len;
		if (!(*iterator == 0)) {
			len++;
		} else {
			break;
		}
		
	}





  return len;
}

/*
 * Returns the length of the initial portion of str1 which consists only of characters that are part of str2.
 * The search does not include the terminating null-characters of either strings, but ends there.
 * 
 * Example, stringSpan("abcdefgh", "abXXcdeZZh"); // returns 5
 *  
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *, ==, !=, <, >
 *   Unary integer operators: !
 *   Shorthand operators based on the above: ex. <<=, *=, ++, --, etc.
 *   Control constructs: for, while
 *
 * DISALLOWED:
 *   Pointer operators: [] (Array Indexing Operator)
 *   Binary integer operators: &, &&, |, ||, <<, >>, ^, /, %
 *   Unary integer operators: ~, -
 */
int stringSpan(char * str1, char * str2) {
  // Your code here

	int returnval = 0, reachedend = 0;
	char* it1 = 0;
       	char* it2 = 0;
	it1 = str1;
	it2 = str2;
	//iterate over the first string (str1)
	while (1) {
		//if we reached the end of the second string without finding
		//a match exit the str1 iteration
		if (reachedend) {
			break;
		}
		//if we havent reached the end of str1
		if (*it1 != 0) {
			//iterate over str2
			while (1) {
				//if we havent reached end of str2
				if (*it2 != 0){
					//if str1 location value is the same as str2 location value,
					if (*it1 == *it2) {
						//increment returnval, reset it2 to front of str2 and move tf on
						returnval++;
						it2 = str2;
						break;

					//if str1[it1] != str2[it2] go next char in str2
					} else {
						it2++;		
					}
				//if we reached end of str2 then halt iteration and return
				} else {
					reachedend = 1;
					break;
				}	
			}
		//reached end of str1? return
		} else {
			break;
		}
		//go next str1 char
		it1++;
	}


  return returnval;
}

/*
 * Change the value pointed to by ptr byte-by-byte so that when returned as an integer
 * the value is 449449.
 *
 * Hint: Remember that an int is 4 bytes.
 *
 * Hint: Remember how little endian works for data storage, how is it different between an multiple bytes(int) and a single byte?
 *
 * Hint: It will be easiest to start convert 449449 into binary form and starting seeing how the endian works from there.
 *
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *
 *   Shorthand operators based on the above: ex. +=, *=, ++, --, etc.
 *   Unary integer operators: !
 *
 * DISALLOWED:
 *   Pointer operators: [] (Array Indexing Operator)
 *   Binary integer operators: &, &&, |, ||, <, >, <<, >>, ==, !=, ^, /, %
 *   Unary integer operators: ~, -
 */
int endianExperiment(int * ptr) {
  char *bytePtr;
	bytePtr = (char*)ptr;
	
	//cheesy way of doing this but brute force works bc theres 4 values
	//and i dont care enough to be clever
	*bytePtr = 0xA9;
	bytePtr++;
	*bytePtr = 0xDB;
	bytePtr++;
	*bytePtr = 0x06;
	bytePtr++;
	*bytePtr = 0x00;



  // Your code here
  return *ptr;
}


/*
 * Selection sort is a sorting algorithim that works by partitioning the array into
 * a sorted section and unsorted section. Then it repeatedly selects the minimum element
 * from the unsorted section and moves it to the end of the sorted section.
 *
 * So the pseudo-code might look something like this:
 * arr - an array
 * n - the length of arr
 *
 * for i = 0 to n - 1
 *   minIndex = i
 *   for  j = i + 1 to n
 *       if arr[minIndex] > arr[j]
 *           minIndex = j
 *       end if
 *   end for
 *   Swap(arr[i], arr[minIndex])
 * end for
 *
 * Implement selection sort below, it might be helpful to use the swapInts function you
 * defined earlier.
 *
 * ALLOWED:
 *   Pointer operators: *, &
 *   Binary integer operators: -, +, *, ==, !=, <, >
 *   Unary integer operators: !
 *   Shorthand operators based on the above: ex. +=, *=, ++, --, etc.
 *   Control constructs: for, while, if
 *   Function calls: swapInt()
 *
 * DISALLOWED:
 *   Pointer operators: [] (Array Indexing Operator)
 *   Binary integer operators: &, &&, |, ||, <<, >>, ^, /
 *   Unary integer operators: ~, -
 */
void selectionSort(int arr[], int arrLength) {
  int i, j, min_index;
  //i literally just copied the selectionsort format from above. not much to comment
  //thought i would need to arrptr value but i really didnt but theres no rzn to change it now
  int* arrptr = arr;
	for (i = 0; i < arrLength-1; i++) {
		min_index = i;
		for (j = i + 1; j < arrLength; j++) {
			arrptr = arr;
			if (*(arrptr + i) > *(arrptr + j)) {
				min_index = j;
			}
		}	
		swapInts((arrptr + i), (arrptr + min_index));
	}  // Your code here
}
