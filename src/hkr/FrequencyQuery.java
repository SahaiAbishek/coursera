package hkr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQuery {
	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> returnList = new ArrayList<>();
		for (List<Integer> query : queries) {
			Integer operation = query.get(0);
			Integer number = query.get(1);
			switch (operation) {
			case 1:
				if (map.containsKey(number)) {
					int freq = map.get(number);
					map.put(number, freq+1);
				} else {
					map.put(number, 1);
				}
				break;
			case 2:
				if (map.containsKey(number)) {
					int freq = map.get(number);
					if(freq <= 1){
						map.remove(number);
					}else{
						map.put(number, freq-1);
					}
				}
				break;
			case 3:
				if (map.containsValue(number)) {
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
