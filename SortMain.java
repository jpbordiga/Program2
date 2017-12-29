// JEFF BORDIGA
// PROGRAM2
// 9/22/17

// Computes the runtimes for both InsertionSort() and MergeSort() algorithms

// MergeSort() becomes faster than InsertionSort() at around the 2^9+ mark

import java.util.ArrayList;
import java.util.Random;

public class SortMain {
	
	public static void main(String[] args) {
		
		for(int n = 8; n <= 8192; n+=n){
			
			ArrayList<Integer> arr = randomArray(n); // creating new random ArrayList
			int iter = Math.max(4, (8192 / n)); // computing iteration value
			
			InsertionSort iS = new InsertionSort();
			ArrayList<Integer> list1 = iS.copyArray(arr);
			
			long sum1 = 0; // starting first timer
			CpuTimer timer1 = new CpuTimer();
			
			for (long i = 0; i < 100_000_000; ++i){
			      sum1 += i;
			}
			
			for(int i = 0; i < iter; i++){
				iS.insertionSort(list1); // iteratively calling InsertionSort()
			}
			
			double totalTime1 = timer1.getElapsedCpuTime(); // computing timing values
			double avgTime1 = totalTime1 / iter;
			
			if(iS.checkSum(arr) != iS.checkSum(list1)){ // checking conditions
				System.out.println("ERROR: sums did not match");
				break;
			}
			
			if((iS.isSorted(arr) != false) || (iS.isSorted(list1) == false)){
				System.out.println("ERROR: incorrect truth values");
				break;
			}
			
			// repeating process for MergeSort()
			
			MergeSort mS = new MergeSort();
			ArrayList<Integer> list2 = mS.copyArray(arr);
			
			long sum2 = 0; // starting second timer
			CpuTimer timer2 = new CpuTimer();
			
			for (long i = 0; i < 100_000_000; ++i){
			      sum2 += i;
			}
			
			for(int i = 0; i < iter; i++){
				mS.mergeSort(list2); // iteratively calling MergeSort()
			}
			
			double totalTime2 = timer2.getElapsedCpuTime();  // computing timing values
			double avgTime2 = totalTime2 / iter;
			
			if(mS.checkSum(arr) != mS.checkSum(list2)){ // checking conditions
				System.out.println("ERROR: sums did not match");
				break;
			}
			
			if((mS.isSorted(arr) != false) || (mS.isSorted(list2) == false)){
				System.out.println("ERROR: incorrect truth values");
				break;
			}
			
			System.out.println("Avg. times for n = " + n + ": " + "InsertionSort() = " + avgTime1 + " sec.; " + "MergeSort() = " + avgTime2 + " sec."); // outputting results
			System.out.println();
			
		}
		
	}
	
	public static ArrayList<Integer> randomArray(int n){ // creates an ArrayList of size n containing random values
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		Random rNG = new Random();
		
		for(int i = 0; i < n; i++){
			arr.add(rNG.nextInt());
		}
		
		return arr;
		
	}

}