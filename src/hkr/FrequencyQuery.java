package hkr;

import java.util.ArrayList;
import java.util.List;

public class FrequencyQuery {
	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<int[]> queries) {
		int arr[] = new int[1000000];
		int freqArr[] = new int[1000000];
		List<Integer> returnList = new ArrayList<>();
		for (int[] query : queries) {
			Integer operation = query[0];
			Integer number = query[1];
			switch (operation) {
			case 1:
				int freq = arr[number];
				arr[number] = freq + 1;
				if (freq > 0) {
					freqArr[freq] -= 1;
				}
				freqArr[freq + 1] = freqArr[freq+1] + 1;
				break;
			case 2:
				int freq1 = arr[number];
				if (freq1 > 0) {
					int newFreq = freq1 - 1;
					arr[number] = newFreq;
					freqArr[freq1]-=1;
					if(newFreq > 0 ){
						freqArr[newFreq]+=1;
					}
					
				}
				break;
			case 3:
				if (freqArr[number] > 0) {
					returnList.add(1);
				} else {
					returnList.add(0);
				}
				break;
			default:
				break;
			}
		}
		return returnList;
	}

}
