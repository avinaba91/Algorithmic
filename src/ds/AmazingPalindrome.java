package ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AmazingPalindrome {

	static String in = "abaa";
	static int count = 0;
	static List<String> strList = new ArrayList<>();

	static boolean isAmazingPalinDrome (String s) {
		if (s == null || "".equals(s)) {
			return false;
		}
		boolean isAmazingPalinDrome = true;
		int firstIndex = 0;
		int lastIndex = s.length() - 1;
		char prevCurrent = '\0';
		char prevLast = '\0';
		if (firstIndex >= 0 && lastIndex >= 0) {
			while ((lastIndex-firstIndex) > 1) {
				char initialCurrent = s.charAt(firstIndex);
				if (initialCurrent == prevCurrent) {
					firstIndex ++;
					continue;
				}
				char lastCurrent = s.charAt(lastIndex);
				if (lastCurrent == prevLast) {
					lastIndex --;
					continue;
				}
				if (initialCurrent == lastCurrent) {
					firstIndex ++;
					lastIndex --;
					prevCurrent = initialCurrent;
					prevLast = lastCurrent;
				} else {
					isAmazingPalinDrome = false;
					break;
				}
			}
		}
		return isAmazingPalinDrome;
	}

	static void substrings(int start, int end) {
		if (start == in.length() && end == in.length()) {
			return;
		} else {
			if (end == in.length() + 1) {
				substrings(start + 1, start + 1);
			} else {
				String subStr = in.substring(start, end);
				subStr = subStr.trim();
				if (subStr != null && subStr != "" && !strList.contains(subStr)) {
					strList.add(subStr);
					if (isAmazingPalinDrome(subStr)) {
						//System.out.println(subStr);
						count ++;
					}
				}
				substrings(start, end + 1);
			}
		}
	}

	public static void main(String[] args) {
		substrings(0, 1);
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(count);
	}

}
