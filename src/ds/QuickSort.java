package ds;

public class QuickSort {
	
	public static void sort (int arr[], int start, int end) {
		if (end > start) {
			int pIndex = partition(arr, start, end);
			sort(arr, start, pIndex-1);
			sort(arr, pIndex + 1, end);
		}
	}
	
	public static int partition (int arr[], int start, int end) {
		int pIndex = start;
		int pivotVal = arr[end];
		for (int i = start ; i <end; i++) {
			if (arr[i] <= pivotVal) {
				swap(arr, i, pIndex);
				pIndex ++;
			}
		}
		swap(arr,pIndex, end);
		return pIndex;
	}
	
	public static void swap(int arr[], int a, int b) {
		if(arr[a] != arr[b]) {
			arr[a] = arr[a] + arr[b];
			arr[b] = arr[a]- arr[b];
			arr[a] = arr[a]- arr[b];
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {2,3,5,1,4,19,11,12,21,32,17,22,34};
		sort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
