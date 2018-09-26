package ds;

import java.util.HashMap;
import java.util.Map;

public class JumpingJack {

	static int maxStep(int n, int k) {
		int maxStep = 0;
		Map<Integer, Map<Integer, Integer>> map = getStepMap(n);
		int maxSum = getMaxSum(n);
		for (int i = 1; i <= n; i++) {
			int value = getMaxStep(map, i, k);
			if (value == maxSum) {
				maxStep = value;
				break;
			}
			if (value > maxStep) {
				maxStep = value;
			}
		}
		return maxStep;
	}
	
	static Map<Integer, Map<Integer, Integer>> getStepMap (int n) {
		Map<Integer, Map<Integer, Integer>> stepMap = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			int count = 0;
			for (int j = i; j<=n; j++) {
				map.put(++count, j);
			}
			stepMap.put(i, map);
		}
		return stepMap;
	}
	
	static int getMaxStep (Map<Integer, Map<Integer, Integer>> map, int val, int k) {
		int sum = 0;
		for (int key : map.keySet()) {
			Map<Integer, Integer> stepMap = map.get(key);
			int step = 0;
			if (stepMap.size() >= val) {
				step = stepMap.get(val);
				sum = sum + step;
			}
			if (sum == k) {
				sum = 0;
				break;
			}
		}
		return sum;
	}
	
	static int getMaxSum (int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + i;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(maxStep(3, 3));
	}
}
