package ds;

/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 3 = Fizz 5 = Buzz 3*5 = FizzBuzz
 * 
 * @author AVINABA
 *
 */
class FizzBuzz {
	public static void print(int number) {
		if (number > 0) {
			for (int i = 1; i <= number; i++) {
				if ((i % 3 == 0) && (i % 5 == 0)) {
					System.out.println("FizzBuzz");
				} else if (i % 5 == 0) {
					System.out.println("Buzz");
				} else if (i % 3 == 0) {
					System.out.println("Fizz");
				} else {
					System.out.println(i);
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int T = Integer.parseInt(line);
		if (T >= 1 && T <= 10) {
			String numberStr = br.readLine();
			String numberArr[] = numberStr.split(" ");
			if (numberArr.length == T) {
				for (int i = 0; i < numberArr.length; i++) {
					int number = Integer.parseInt(numberArr[i]);
					print(number);
				}
			}
		}
	}
}