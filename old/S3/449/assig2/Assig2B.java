
public class Assig2B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//int iterations = Integer.parseInt(args[0]);
		int iterations = 160000;
		
		
		System.out.println("Iterating " + iterations + " times.\nAppending:");
		StringBuilder SB = new StringBuilder();
		long start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			SB.append('A');
		}
		long end = System.nanoTime();
		System.out.println("SB (total):  " + (end - start));
		System.out.println("SB (T/I):    " + (end-start)/iterations);
/////////////////////////////////////////////////////////////////////////////////////////////////
		MyStringBuilder MSB = new MyStringBuilder();
		start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			MSB.append('A');
		}
		end = System.nanoTime();
		System.out.println("MSB (total): " + (end - start));
		System.out.println("MSB (T/I):   " + (end-start)/iterations);
//////////////////////////////////////////////////////////////////////////////////////////////////
		String S = new String();
		start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			S += 'A';
		}
		end = System.nanoTime();
		System.out.println("S (total):   " + (end - start));
		System.out.println("S (T/I):     " + (end-start)/iterations);
//////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		System.out.println("\nDeleting:");
		start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			SB.delete(0,1);
		}
		end = System.nanoTime();
		System.out.println("SB (total):  " + (end - start));
		System.out.println("SB (T/I):    " + (end-start)/iterations);
//////////////////////////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			MSB.delete(0,1);
		}
		end = System.nanoTime();
		System.out.println("MSB (total): " + (end - start));
		System.out.println("MSB (T/I):   " + (end-start)/iterations);
//////////////////////////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			S.substring(0,S.length());
		}
		end = System.nanoTime();
		System.out.println("S (total):   " + (end - start));
		System.out.println("S (T/I):     " + (end-start)/iterations);
//////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		System.out.println("\nInserting:");
		start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			SB.insert(SB.length()/2,'A');
		}
		end = System.nanoTime();
		System.out.println("SB (total):  " + (end - start));
		System.out.println("SB (T/I):    " + (end-start)/iterations);
//////////////////////////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			MSB.insert(MSB.length()/2,'A');
		}
		end = System.nanoTime();
		System.out.println("MSB (total): " + (end - start));
		System.out.println("MSB (T/I):   " + (end-start)/iterations);
//////////////////////////////////////////////////////////////////////////////////////////////////
		start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			S = S.substring(0, S.length()/2) + 'A' + S.substring(S.length()/2);
		}
		end = System.nanoTime();
		System.out.println("S (total):   " + (end - start));
		System.out.println("S (T/I):     " + (end-start)/iterations);
//////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
		
		
	}

}
