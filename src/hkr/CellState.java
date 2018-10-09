package hkr;

import java.util.ArrayList;
import java.util.List;

public class CellState {

	public static List<Integer> cellCompete(int[] states, int days) {
		List<Integer> retlist = new ArrayList<>();
		int nextStates[] = new int[8];

		int count = 0;
		while (count < days) {
			// check for first
			if (states[1] == 0) {
				nextStates[0] = 0;
			} else {
				nextStates[0] = 1;
			}
			// check for rest
			for (int i = 1; i < states.length - 1; i++) {
				if (states[i - 1] == states[i + 1]) {
					nextStates[i] = 0;
				} else {
					nextStates[i] = 1;
				}
			}

			// check for last
			if (states[6] == 0) {
				nextStates[7] = 0;
			} else {
				nextStates[7] = 1;
			}
			states = nextStates;
			nextStates = new int[8];
			count++;
		}
		for (int i = 0; i < states.length; i++) {
			retlist.add(states[i]);
		}
		return retlist;
	}

	public static void main(String[] args) {
		int arr[] = {1,1,1,0,1,1,1,1};
		System.out.println(cellCompete(arr, 2));
	}
}
