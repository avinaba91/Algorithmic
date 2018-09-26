package utility;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SampleTestTwo {
	
	public void sort (Map<Integer, Integer> map) {
		List<Integer> values = (List<Integer>) map.values();
		Set<Integer> keys = map.keySet();
		Collections.sort(values);
		for (Integer value : values) {
		for (Integer key : map.keySet()) {
			Integer value1 = map.get(key);
			if (value1 == value) {
				map.remove(key);
				map.put(key, value1);
			}
		}
		}
	}
}
