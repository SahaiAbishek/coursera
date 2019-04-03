/*
 * 
	Example 
	Input: 
	numDestinations = 3 from aonecode.com
	allocations = [[1, 2], [3, 4], [1, -1]] 
	numDeliveries = 2 from a
 */

package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AmazonFresh {

	public static List<List<Integer>> findNearsestCoordinates(List<List<Integer>> locations, int n) {

		List<List<Integer>> result = new ArrayList<>();

		PriorityQueue<List<Integer>> pqLocations = new PriorityQueue<>(new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> l1, List<Integer> l2) {
				Double d1 = Math.sqrt(l1.get(0) * l1.get(0) + l1.get(1) * l1.get(1));
				Double d2 = Math.sqrt(l2.get(0) * l2.get(0) + l2.get(1) * l2.get(1));
				return d1.compareTo(d2);
			}
		});

		for (List<Integer> location : locations) {
			pqLocations.add(location);
		}

		for (int i = 0; i < n; i++) {
			result.add(pqLocations.remove());
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> coordiantesList = new ArrayList<>();
		List<Integer> coords = new ArrayList<>();
		coords.add(1);
		coords.add(2);
		coordiantesList.add(coords);

		coords = new ArrayList<>();
		coords.add(3);
		coords.add(4);
		coordiantesList.add(coords);

		coords = new ArrayList<>();
		coords.add(1);
		coords.add(-1);
		coordiantesList.add(coords);
		
		System.out.println(findNearsestCoordinates(coordiantesList, 2));
	}
}
