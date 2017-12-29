import java.util.ArrayList;
import java.lang.Math;

public class MergeSort implements MergeSortInterface {

	public MergeSort(){
		//
	}
	
	@Override
	public void mergeSort(ArrayList<Integer> arr){ // sorts accepted ArrayList
		mergeSortRecursive(arr, 0, arr.size() - 1);
	}
	
	@Override
	public void mergeSortRecursive(ArrayList<Integer> arr, int p, int r){ // recursively sorts through values
		
		if(p < r){ // beginning of array must be less than the value of r
			int q = (int) Math.floor((p + r) / 2); // computing middle value
			mergeSortRecursive(arr, p, q);
			mergeSortRecursive(arr, (q + 1), r);
			merge(arr, p, q, r);
		}
		
	}

	@Override
	public void merge(ArrayList<Integer> arr, int p, int q, int r){ // using surrogate arrays to merge sorted values back into the original array
		
		int n1 = q - p + 1;
		int n2 = r - q;
		
		ArrayList <Integer> left = new ArrayList<>();
		ArrayList <Integer> right = new ArrayList<>();
		
		for(int i = 1; i <= n1; i++){
			left.add(arr.get(p + i - 1));
		}
		
		for(int j = 1; j <= n2; j++){
			right.add(arr.get(q + j));
		}
		
		left.add(Integer.MAX_VALUE); // practical to use Java's equivalent of infinity
		right.add(Integer.MAX_VALUE);
		
		int i = 0;
		int j = 0;
		
		for(int k = p; k <= r; k++){ // sorting values from surrogate arrays back into target array

			if(left.get(i) <= right.get(j)){
				arr.set(k, left.get(i));
				i = i + 1;
			} else {
				arr.set(k, right.get(j));
				j = j + 1;
			}
		}
		
	}

	@Override
	public ArrayList<Integer> copyArray(ArrayList<Integer> arr1){ // copies original array for use in the sorting algorithm
		
		ArrayList<Integer> arr2 = new ArrayList<>(arr1);
		return arr2;
		
	}

	@Override
	public boolean isSorted(ArrayList<Integer> arr){ // checks if each value A[n] is <= A[n + 1]
		
		boolean result = false;
		
		for(int i = 0; i < arr.size() - 1; i++){ //
			if(arr.get(i) <= arr.get(i + 1)){
				result = true;
			} else {
				result = false;
				break;
			}
		}
		
		return result;
	}

	@Override
	public long checkSum(ArrayList<Integer> arr){ // computes and returns the sum of all the values in the target array
		
		long sum = 0;
		
		for(int i = 0; i < arr.size(); i++){
			sum = sum + arr.get(i);
		}
		
		return sum;
		
	}

}
