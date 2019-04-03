package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AmazonPromeAirShipping {

	public static List<List<Integer>> findRoutes(List<List<Integer>> sources, List<List<Integer>> destinations,
			int maxDist) {

		Map<Integer, List<List<Integer>>> map = new TreeMap<>();

		for (List<Integer> s : sources) {
			for (List<Integer> d : destinations) {
				int dist = s.get(1) + d.get(1);
				if (map.containsKey(dist)) {
					List<List<Integer>> values = map.get(dist);
					List<Integer> cords = new ArrayList<>();
					cords.add(s.get(0));
					cords.add(d.get(0));
					values.add(cords);
					map.put(dist, values);

				} else {
					List<Integer> cords = new ArrayList<>();
					cords.add(s.get(0));
					cords.add(d.get(0));
					List<List<Integer>> values = new ArrayList<>();
					values.add(cords);
					map.put(dist, values);
				}
			}
		}

		System.out.println(map);

		int max = Integer.MIN_VALUE;
		if (map.containsKey(maxDist)) {
			return map.get(maxDist);
		} else {

			Set<Integer> keys = map.keySet();
			for (int key : keys) {
				if (key > maxDist) {
					break;
				}
				if (key > max && key < maxDist) {
					max = key;
				}
			}
		}
		if (max == Integer.MIN_VALUE) {
			return new ArrayList<>();
		} else {
			return map.get(max);
		}

	}

	public static List<List<Integer>> findRoutes1(List<List<Integer>> sources, List<List<Integer>> destinations,
			int maxDist) {

		List<List<Integer>> match = new ArrayList<>();
		// List<List<Integer>> nearest = new ArrayList<>();

		int max = Integer.MIN_VALUE;
		int firstVal = 0;
		int secondVal = 0;

		for (List<Integer> s : sources) {
			for (List<Integer> d : destinations) {
				int dist = s.get(1) + d.get(1);
				if (dist == maxDist) {
					List<Integer> retList = new ArrayList<>();
					retList.add(s.get(0));
					retList.add(d.get(0));
					match.add(retList);
				} else {
					if (dist > max && dist < maxDist) {
						max = dist;
						firstVal = s.get(0);
						secondVal = d.get(0);
					}
				}
			}
		}

		if (match.size() > 0) {
			return match;
		} else if (max != Integer.MIN_VALUE) {
			List<Integer> retList = new ArrayList<>();
			retList.add(firstVal);
			retList.add(secondVal);
			match.add(retList);
			return match;
		}
		return new ArrayList<>();
	}

	public static void main(String[] args) {
		List<List<Integer>> list1 = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(3000);
		list1.add(l1);

		l1 = new ArrayList<>();
		l1.add(2);
		l1.add(5000);
		list1.add(l1);

		l1 = new ArrayList<>();
		l1.add(3);
		l1.add(7000);
		list1.add(l1);

		l1 = new ArrayList<>();
		l1.add(4);
		l1.add(10000);
		list1.add(l1);

		List<List<Integer>> list2 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		l2.add(1);
		l2.add(2000);
		list2.add(l2);

		l2 = new ArrayList<>();
		l2.add(2);
		l2.add(3000);
		list2.add(l2);

		l2 = new ArrayList<>();
		l2.add(3);
		l2.add(4000);
		list2.add(l2);

		l2 = new ArrayList<>();
		l2.add(4);
		l2.add(5000);
		list2.add(l2);

		System.out.println(findRoutes1(list1, list2, 7500));
	}

}
