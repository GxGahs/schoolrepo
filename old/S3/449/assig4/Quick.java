// CS 0445 Fall 2020
// Simple version of QuickSort.  This is similar to the version in the Carrano
// text, except that it uses A[last] as the pivot and partitions based on that
// value.  Compare this to the version of Quicksort in the text (I have copied
// it into the file TextMergeQuick.java)


public class Quick
{
	
	public static <T extends Comparable<? super T>>
		   void quickSort(T[] array, int n, int min_size)
	{
		quickSort(array, 0, n-1, min_size);
	} // end quickSort

	public static <T extends Comparable<? super T>>
		   void quickSort(T[] array, int first, int last, int min_size)
	{
		if (last -first +1 < min_size) {
			insertionSort(array, first, last);
		}
		
		else if (first < last)
		{
			// create the partition: Smaller | Pivot | Larger
			int pivotIndex = partition(array, first, last);
	      
			// sort subarrays Smaller and Larger
			quickSort(array, first, pivotIndex-1, min_size);
			quickSort(array, pivotIndex+1, last, min_size);
		} // end if
	}  // end quickSort

	private static <T extends Comparable<? super T>>
	        int partition(T[] a, int first, int last)
	{
		int pivotIndex = last;  // simply pick pivot as rightmost element
		T pivot = a[pivotIndex];

		// determine subarrays Smaller = a[first..endSmaller]
		//                 and Larger  = a[endSmaller+1..last-1]
		// such that elements in Smaller are <= pivot and 
		// elements in Larger are >= pivot; initially, these subarrays are empty

		int indexFromLeft = first; 
		int indexFromRight = last - 1; 

		boolean done = false;
		while (!done)
		{
			// starting at beginning of array, leave elements that are < pivot; 
			// locate first element that is >= pivot
			while (a[indexFromLeft].compareTo(pivot) < 0)
				indexFromLeft++;

			// starting at end of array, leave elements that are > pivot; 
			// locate first element that is <= pivot

			while (a[indexFromRight].compareTo(pivot) > 0 && indexFromRight > first)
				indexFromRight--;

			// Assertion: a[indexFromLeft] >= pivot and 
			//            a[indexFromRight] <= pivot.

			if (indexFromLeft < indexFromRight)
			{
				swap(a, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}
			else 
				done = true;
		} // end while

		// place pivot between Smaller and Larger subarrays
		swap(a, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;

		// Assertion:
		// Smaller = a[first..pivotIndex-1]
		// Pivot = a[pivotIndex]
		// Larger  = a[pivotIndex + 1..last]

		return pivotIndex; 
	}  // end partition

	private static void swap(Object [] a, int i, int j)
	{
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp; 
	} // end swap
	
	public static <T extends Comparable<? super T>> 
    void insertionSort(T[] a, int first, int last)
	{
		int unsorted, index;
		
		for (unsorted = first + 1; unsorted <= last; unsorted++)
		{   // Assertion: a[first] <= a[first + 1] <= ... <= a[unsorted - 1]
		
			T firstUnsorted = a[unsorted];
			
			insertInOrder(firstUnsorted, a, first, unsorted - 1);
		} // end for
	}
	private static <T extends Comparable<? super T>> 
    void insertInOrder(T element, T[] a, int begin, int end)
	{
	int index;
	
	for (index = end; (index >= begin) && (element.compareTo(a[index]) < 0); index--)
	{
		a[index + 1] = a[index]; // make room
	} // end for
	
	// Assertion: a[index + 1] is available
	a[index + 1] = element;  // insert
	} // end insertInOrder
}
