package coursera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AmazonGrocery {

	private class Location implements Comparable<Location> {
		private double distance;
		private int x;
		private int y;

		public Location(double distance, int x, int y) {
			super();
			this.distance = distance;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Location loc) {
			if (this.distance < loc.distance) {
				return -1;
			} else if (this.distance < loc.distance) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations,
			int numDeliveries) {
		List<Location> locList = new ArrayList<>();
		List<List<Integer>> retList = new ArrayList<>();
		for (List<Integer> location : allLocations) {
			int x = location.get(0);
			int y = location.get(1);
			double distSq = (x * x) + (y * y);
			double dist = Math.sqrt(distSq);
			locList.add(new Location(dist, x, y));
		}

		for (int i = 0; i < numDeliveries; i++) {
			Location l = locList.get(i);
			List<Integer> lst = new ArrayList<>();
			lst.add(l.x);
			lst.add(l.y);
			retList.add(lst);
		}
		return retList;
	}

	public List<List<Integer>> optimalUtilization(int maxTravelDist, List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList) {
		List<List<Integer>> retListS = new ArrayList<>();
		int max = 0;
		List<Integer> tempRetList = new ArrayList<>();
		for (int i = 0; i < forwardRouteList.size(); i++) {
			List<Integer> f = forwardRouteList.get(i);
			int num = f.get(0);
			int dist = f.get(1);
			for (int j = 0; j < returnRouteList.size(); j++) {
				List<Integer> retList = new ArrayList<>();
				List<Integer> r = forwardRouteList.get(j);
				int numReturn = r.get(0);
				int distReturn = r.get(1);
				int totalDist = dist + distReturn;
				if (totalDist == maxTravelDist) {
					retList.add(num);
					retList.add(numReturn);
					retListS.add(retList);
				}
				if (totalDist < maxTravelDist) {
					if (totalDist > max) {
						tempRetList = new ArrayList<>();
						max = totalDist;
						tempRetList.add(num);
						tempRetList.add(numReturn);
					}
				}
			}
		}
		if (retListS.size() > 0) {
			return retListS;
		} else {
			retListS.add(tempRetList);
			return retListS;
		}
	}

	public static void main(String[] args) {

		AmazonGrocery amazonGrocery = new AmazonGrocery();
		List<List<Integer>> allLocations = new ArrayList<>();
		List<Integer> lst = new ArrayList<>();
		lst.add(2);
		lst.add(2);
		allLocations.add(lst);
		lst = new ArrayList<>();
		lst.add(3);
		lst.add(3);
		allLocations.add(lst);
		lst = new ArrayList<>();
		lst.add(9);
		lst.add(9);
		allLocations.add(lst);
		lst = new ArrayList<>();
		lst.add(8);
		lst.add(8);
		allLocations.add(lst);
		lst = new ArrayList<>();
		lst.add(6);
		lst.add(6);
		allLocations.add(lst);
		List<List<Integer>> ret = amazonGrocery.ClosestXdestinations(5, allLocations, 4);
		System.out.println(ret);
	}
}
