import java.util.ArrayList;

public interface MergeSortInterface {

	public void mergeSort(ArrayList<Integer> arr);
	public void mergeSortRecursive(ArrayList<Integer> arr, int p, int r);
	public void merge(ArrayList<Integer> arr, int p, int q, int r); // p <= q < r; subroutine
	public ArrayList<Integer> copyArray(ArrayList<Integer> arr1);
	public boolean isSorted(ArrayList<Integer> arr);
	public long checkSum(ArrayList<Integer> arr);
	
}
