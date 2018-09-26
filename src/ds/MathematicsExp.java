package ds;

public class MathematicsExp {

	int i, top = 0;
	char a[] = new char[50];

	void push(char c) {
		a[top] = c;
		top++;
	}

	char pop() {
		char h;
		if (top != 0) {
			top--;
			h = a[top];
			return h;
		} else {
			return 0;
		}
	}
	
	/**
	 * This method will return the last parenthesis stored in the stack.If it finds any
	 * operator then it will pop and ignore that.  
	 * @return
	 */
	char getOperator() {
		char c = 0;
		while (!isEmpty()) {
			c = pop();
			if (c == '+' || c == '-' || c == '*'  || c == '/') {
				c = 0;
				continue;
			} else {
				break;
			}
		}
		return c;
	}

	boolean isEmpty() {
		if (top == 0) {
			return true;
		} else {
			return false;
		}
	}

	boolean isValid(String str) {
		boolean invalid = false;
		char d, t;
		boolean operator = true;
		for (i = 0; i < str.length(); i++) {
			d = str.charAt(i);
			switch (d) {
			case '(': {
				push(d);
				break;
			}
			case '{': {
				push(d);
				break;
			}
			case '[': {
				push(d);
				break;
			}
			case ')': {
				t = getOperator();
				if (t != '(') {
					invalid = true;
				}
				break;
			}
			case '}': {
				t = getOperator();
				if (t != '{') {
					invalid = true;
				}
				break;
			}
			case ']': {
				t = getOperator();
				if (t != '[') {
					invalid = true;
				}
				break;
			}
			case '*':
			case '/':
			case '+':
			case '-': {
				if (operator) {
					invalid = true;
				}
				push(d);
				operator = true;
				break;
			}
			default: 
				if (!operator) {
					invalid = true;
				}
				operator = false;
				break;
			}
			if (invalid) {
				return false;
			}
		}
		//Check whether the stack contains any parenthesis or not
		char x = getOperator();
		if (x == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String expr = "a*(b+c-d)/f";
		MathematicsExp mathematicsExp = new MathematicsExp();
		System.out.println(mathematicsExp.isValid(expr));
	}
}
