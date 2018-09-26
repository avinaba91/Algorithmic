package ds;

import java.util.ArrayList;
import java.util.List;

public class Delta {

	static int[] delta_encode(int[] array) {
		int[] output = new int[array.length * 3];
		int prevVal = 0;
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			int input = 0;
			if (i == 0) {
				input = array[i];
			} else {
				input = array[i] - prevVal;
				if (input < -127 || input > 127) {
					output[counter++] = -128;
				}
			}
			output[counter++] = input;
			prevVal = array[i];
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int text : output) {
			if (text != 0) {
				list.add(text);
			}
		}
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			arr[i] = list.get(i);
		return arr;
	}

	public static void main(String[] args) {
		int[] array = { 25626, 25757, 24367, 24267, 16, 100, 2, 7277 };
		int[] output = delta_encode(array);
		for (int i = 0; i < output.length; i++) {
			System.out.println(String.valueOf(output[i]));
		}
	}
}
