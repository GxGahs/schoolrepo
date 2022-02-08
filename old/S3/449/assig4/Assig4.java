
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class Assig4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size of array:");
		int arrsize = sc.nextInt();
		System.out.println("enter number of trials:");
		int trials = sc.nextInt();
		System.out.println("enter name of file:");
		String what = sc.nextLine();
		String filename = sc.nextLine();

		int[] minSizeArray = {5,50,150};
		String[] dataSetupArray = {"Random", "Lo to Hi", "Hi to Lo"};
		String[] sortTypeArray = {"quickSort (default)", "quickSort (Median of 3)", "quickSort (random)", "mergeSort (default)"};
		Random RNG = new Random();
		boolean TraceOutputMode = arrsize < 20;
		
		Integer[] arr = new Integer[arrsize];
		
		PrintStream out;
		try {
			out = new PrintStream(
			        new FileOutputStream(filename + ".txt", true), true);
			System.setOut(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		for (int k = 0; k < minSizeArray.length; k++) {
			SortAlgorithms.setMinSize(minSizeArray[k]);
			double[] sum  = {0,0,0,0};
			for (int i = 0; i < 3; i++) {
				
				
				for (int tri = 0; tri < trials; tri++) {
					
					switch (i) {
					case 0:
						for (int j = 0; j < arrsize; j++) {
							arr[j] = RNG.nextInt(arrsize);
						}
						break;
					case 1:
						for (int j = 0; j < arrsize; j++) {
							arr[j] = j;
						}
						break;
					case 2:
						for (int j = 0; j < arrsize; j++) {
							arr[j] = arrsize - j;
						}
						break;
					}
					
					
					Integer[] sortedArray = new Integer[arrsize];
					for (int c = 0; c < arrsize; c++) {
						sortedArray[c] = arr[c];
					}
					
					//for each of the sorting algorithms conduct n trials and average
					for (int l = 0; l < 4; l++) {
						switch (l) {
							case 0:
								long start = System.nanoTime();
								SortAlgorithms.quickSort(sortedArray, arrsize);
								long end = System.nanoTime();
								sum[l] += end - start;
								
								break;
							case 1:
								 start = System.nanoTime();
								SortAlgorithms.quickSortMOT(sortedArray, arrsize);
								end = System.nanoTime();
								sum[l] += end - start;
								
								break;
							case 2:
								start = System.nanoTime();
								SortAlgorithms.quickSortRandom(sortedArray, arrsize);
								end = System.nanoTime();
								sum[l] += end - start;
								
								break;
							case 3:
								start = System.nanoTime();
								SortAlgorithms.quickSort(sortedArray, arrsize);
								end = System.nanoTime();
								sum[l] += end - start;
								
								break;
								
							
						}
						
						if (TraceOutputMode) {
							System.out.println("Algorithm: " + sortTypeArray[l]);
							System.out.println("Array Size: " + arrsize);
							System.out.println("Base case less than: " + minSizeArray[k]);
							System.out.println("Data Setup: " + dataSetupArray[i]);
							System.out.println("Trial: " + tri);
							for (int b = 0; b < arrsize-1; b++) {
								System.out.print(arr[b] + ", ");
							}
							System.out.println(arr[arrsize-1]);
							for (int b = 0; b < arrsize-1; b++) {
								System.out.print(sortedArray[b] + ", ");
							}
							System.out.println(sortedArray[arrsize-1]);
							System.out.println("------------------------------------------------");
						}
						//System.out.println("Average Time per Trial: " + String.format("%.9f", avgtime) + " seconds");
						//System.out.println("------------------------------------------------");
						
						for (int c = 0; c < arrsize; c++) {
							sortedArray[c] = arr[c];
						}

					}
				}//finish conducting n trials complete with printing if in TraceOut mode and summing of times.
				
				if (!TraceOutputMode) {
					
					for (int c = 0; c < 4; c++) {
						
						System.out.println("Algorithm: " + sortTypeArray[c]);
						System.out.println("Array Size: " + arrsize);
						System.out.println("Base case less than: " + minSizeArray[k]);
						System.out.println("Data Setup: " + dataSetupArray[b]);
						System.out.println("Trials: " + trials);
						System.out.println("Average Time per Trial: " + String.format("%.9f", sum[c]/1000000000/trials) + " seconds");
						System.out.println("------------------------------------------------");
					}
					
				}
				 //print while not in 
				
				
				
			}		
			
			
				
				
			
		}

	}

}
