package ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SquareProblem {
	
	private static int count = 0;
	private static List<Integer> removedVerticalList = new ArrayList<>();
	private static List<Integer> removedHorizantalList = new ArrayList<>();
	
	public static long squareCount(long N) {
		long count = (N * (N+1) * (2*N+1))/6;
		return count;
	}
	
	public static void countSquare(int base, int lines) {
		int segmentCount = (lines-1) * (lines-1);
		int maxCount = (lines-1) * lines;
		int v = 1;
		for (int h = 1; h < segmentCount;) {
			int h1 = h;
			int v1 = v;
			while( v1 <= segmentCount ) {
				boolean remoedSegmentPresent = false;
				List<Integer> horizontalList = new ArrayList<>();
				List<Integer> verticalList = new ArrayList<>();
				int h2 = 0;
				int v2 = 0;
				for (int i = 0; i < base; i++) {
					int x1 = h1 + i;
					if (removedHorizantalList.contains(x1)) {
						remoedSegmentPresent = true;
					}
					horizontalList.add(h1 + i);
					h2 = h1 + (base * (lines -1)) + i;
					int x2 = h2;
					if (removedHorizantalList.contains(x2)) {
						remoedSegmentPresent = true;
					}
					horizontalList.add(h2);
					int y1= v1 +1;
					if (removedVerticalList.contains(y1)) {
						remoedSegmentPresent = true;
					}
					verticalList.add(v1 + i);
					v2 = v1 + (base * (lines -1)) + i;
					int y2= v2;
					if (removedVerticalList.contains(y2)) {
						remoedSegmentPresent = true;
					}
					verticalList.add(v2);
				}
				if (v2 > maxCount || h2 > maxCount) {
					break;
				}
				h1++;
				v1 = v1 + lines -1;
				if (!remoedSegmentPresent) {
					count ++;
				}
			}
			h = h + (lines -1);
			v++;
		}
	}
	
	


	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int N = Integer.parseInt(s.nextLine());
		int segmentCount = Integer.parseInt(s.nextLine());
		for (int i = 0; i < segmentCount; i++) {
			String removedSegmentInfo = s.nextLine();
			String str[] = removedSegmentInfo.split(",");
			String info = str[0];
			int row = Integer.parseInt(str[1]);
			int column = Integer.parseInt(str[2]);
			int position = (N-1)*(row-1) + column;
			if ("H".equals(info)) {
				removedHorizantalList.add(position);
			} else if ("V".equals(info)) {
				removedVerticalList.add(position);
			}
		}
		for (int i = 1; i < N; i++) {
			countSquare(i, N);
		}
		System.out.println(count);
	}
}
