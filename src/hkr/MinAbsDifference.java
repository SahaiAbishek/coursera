package hkr;

import java.util.Arrays;

public class MinAbsDifference {

	// Complete the minimumAbsoluteDifference function below.
	static int minimumAbsoluteDifference(int[] arr) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length-1; i++) {
			int val = Math.abs(arr[i] - arr[i+1]);
			if(min > val){
				min = val;
			}
		}
		return min;
	}

	public static void main(String[] args) {

	}

}
