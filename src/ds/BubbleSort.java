package ds;


public class BubbleSort {

	
	public static void sort (int[] arr) {
		int n = arr.length;
		for (int i = 0 ; i < n-1; i++) {
			for (int j = 0 ; j < n-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {92,7,1,10,9,75,4};
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
