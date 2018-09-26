package utility;

public class SampleTestOne {

	public static void main(String[] args) {
		String s = "1 2 3";
		String str[] = s.split("\\s+");
		System.out.println(Long.parseLong(str[0]));
		System.out.println(Long.parseLong(str[1]));
		System.out.println(Long.parseLong(str[2]));

	}

}
