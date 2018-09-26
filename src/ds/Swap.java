package ds;

public class Swap {
	
	public static void swap(int a, int b) {
		if (a != b) {
			a = a + b;
			b = a-b;
			a = a-b;
		}
		System.out.println("a :: " + a + " and b : " + b);
	}

	public static void main(String[] args) {
		int a = 10;
		int b = 2;
		swap(a, b);

	}

}
