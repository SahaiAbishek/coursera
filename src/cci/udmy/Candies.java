package cci.udmy;

import java.util.HashMap;
import java.util.Map;

public class Candies {
	public int distributeCandies(int[] candies) {
		int total = candies.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int candie : candies) {
			if (map.containsKey(candie)) {
				int num = map.get(candie);
				map.put(candie, num + 1);
			} else {
				map.put(candie, 1);
			}
		}
		int sz = map.size();
		if (total / 2 < sz) {
			return total / 2;
		} else {
			return sz;
		}
	}
}
