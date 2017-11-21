package hkr;

import java.util.HashMap;
import java.util.Map;

public class DavidsStaircase {

	private Map<Integer, Integer> map = new HashMap<>();

	public int clacSteps(int steps) {
		if (steps == 0) {
			return 1;
		}
		if (steps == 1) {
			return 1;
		}
		if (steps == 2) {
			map.put(steps, 2);
			return 2;
		}
		if (map.containsKey(steps)) {
			return map.get(steps);
		} else {
			int total = clacSteps(steps - 3);
			total += clacSteps(steps - 2);
			total += clacSteps(steps - 1);
			map.put(steps, total);
			return total;
		}
	}

	public static void main(String[] args) {
		DavidsStaircase ds = new DavidsStaircase();
		int n = ds.clacSteps(7);
		System.out.println(n);
	}

}
