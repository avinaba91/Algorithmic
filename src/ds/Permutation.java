package ds;

public class Permutation {
	
	public static void permutation (char[] str, int i, int n) {
		if ( i == n) {
			System.out.println(str);
		} else {
			for (int j = i; j < n; j++) {
				char temp = str[i];
				str[i] = str[j];
				str[j] = temp;
				permutation(str, i + 1, n);
				char temp1 = str[i];
				str[i] = str[j];
				str[j] = temp1;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		char str[] = {'M', 'A', 'N'};
	    permutation(str, 0, 3);
	}

}
