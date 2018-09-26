package ds;

import java.util.Scanner;

public class ScooBy {
	
	public static long getCount(long A, long B, long N) {
		long count = 1;
		long initialFrnd = A;
		while (A <= N) {
			A = A + B;
			if (A > N) {
				A = A-N;
			}
			if (A == initialFrnd) {
				break;
			} else {
				count ++;
			}
		}
		return count;
	}

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in); 
		int testCases = s.nextInt();
		for (int i = 0; i < testCases; i++) {
			long A = s.nextInt();
			long B = s.nextInt();
			long N = s.nextInt();
			System.out.println(getCount(A, B, N));
		}
	}
}
