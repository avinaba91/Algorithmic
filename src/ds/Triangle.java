package ds;

public class Triangle {
	
	// Complete the triangle function below.
    static int triangle(int a, int b, int c) {
    	if (isTriangleValid(a, b, c)) {
    		if (a == b && b == c) {
    			return 1;
    		} else {
    			return 2;
    		}
    	} else {
    		return 0;
    	}

    }

	private static boolean isTriangleValid(int a, int b, int c) {
		if ((a + b) > c && (a + c) > b && (b + c) > a) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(triangle(3, 3, 3));
	}
}
