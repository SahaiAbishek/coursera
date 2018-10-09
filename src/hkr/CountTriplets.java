package hkr;

import java.util.Arrays;
import java.util.List;

public class CountTriplets {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {
		int count =0;
		
		int len = arr.size();
		for (int i = 0; i < len - 2; i++) {
			for (int j = i+1; j < len - 1; j++) {
				for (int k = j+1; k < len; k++) {
					if ((arr.get(k) == arr.get(j) * r) && (arr.get(j) == arr.get(i) * r)) {
						count++;					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		List<Long> list = Arrays.asList(1L,3L,9L,9L,27L,81L);
		countTriplets(list, 3);
	}

}
