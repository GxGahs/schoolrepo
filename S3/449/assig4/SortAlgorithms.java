


public class SortAlgorithms {
	
	private static int MIN_SIZE;
	
	
	public static void setMinSize(int n) {
		MIN_SIZE = n;
	}
	
	public static <T extends Comparable<? super T>> void quickSortRandom(T[] array, int n) {
		
		QuickRandom.quickSort(array, n, MIN_SIZE);
		
	}
	
	public static <T extends Comparable<? super T>> void quickSortMOT(T[] array, int n) {
		TextMergeQuick.quickSort(array, n, MIN_SIZE);
	}
	
	public static <T extends Comparable<? super T>> void quickSort(T[] array, int n) {
		Quick.quickSort(array, n, MIN_SIZE);
	}
	
	public static <T extends Comparable<? super T>> void mergeSort(T[] array, int n) {
		TextMergeQuick.mergeSort(array, n, MIN_SIZE);
	}
	
	
	

}
