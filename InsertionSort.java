import java.util.ArrayList;

public class InsertionSort implements InsertionSortInterface{
	
	public InsertionSort(){
		//
	}
	
	@Override
	public ArrayList<Integer> insertionSort(ArrayList<Integer> arr){ // sorts the accepted ArrayList
		
		int i = 0;
		int key = 0;
		
		for(int j = 1; j < (arr.size()); j++){ // iteratively sorts values by switching and reinserting

			key = arr.get(j);
			i = j - 1;
			
			while((i >= 0) && (arr.get(i) > key)){
				arr.set((i + 1), arr.get(i));
				i = i - 1;
			}
			arr.set((i + 1), key);
		}
	
		return arr;
	}

	@Override
	public ArrayList<Integer> copyArray(ArrayList<Integer> arr1){ // copies original array for use in the sorting algorithm
		
		ArrayList<Integer> arr2 = new ArrayList<>(arr1);
		return arr2;
		
	}
	
	@Override
	public boolean isSorted(ArrayList<Integer> arr){ // checks if each value A[n] is <= A[n + 1]
		
		boolean result = false;
		
		for(int i = 0; i < arr.size() - 1; i++){
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