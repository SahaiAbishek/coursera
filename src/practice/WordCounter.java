package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordCounter {

	public static Map<String, Integer> maxOccouranceOfWord(String str) {
		Map<String, Integer> map = new HashMap<>();
		int maxCount = 0;
		String maxOccouringWord = "";
		String[] words = str.split(" ");
		for (String word : words) {
			if (map.containsKey(word)) {
				int count = map.get(word);
				count = count + 1;
				if (maxCount < count) {
					maxCount = count;
					maxOccouringWord = word;
				}
				map.put(word, count);
			} else {
				if (maxCount < 1) {
					maxCount = 1;
				}
				map.put(word, 1);
			}
		}

		Map<String, Integer> retMap = new HashMap<>();
		retMap.put(maxOccouringWord, maxCount);
		return retMap;
	}
	
	public static List<Entry<String, Integer>> sortBywordcount(String str) {
		Map<String, Integer> map = new HashMap<>();
		String[] words = str.split(" ");
		for (String word : words) {
			word =word.trim();
			if(word.equals(" ") || word.equals(",") || word.equals(".") || word.equals("!")){
				continue;
			}
			if (map.containsKey(word)) {
				int count = map.get(word);
				count = count + 1;
				map.put(word, count);
			} else {
				map.put(word, 1);
			}
		}

		Set<Entry<String, Integer>> entrySet = map.entrySet();
		List<Entry<String, Integer>> listFromMap = new ArrayList<>(entrySet);
		Collections.sort(listFromMap, new Comparator<Map.Entry<String,Integer>>() {
			@Override
			public int compare(Entry<String, Integer> e1,Entry<String, Integer> e2){
				return e2.getValue().compareTo(e1.getValue());
			}
		});
		
		
		return listFromMap;
	}

	public static void main(String[] args) {
		String str = "test test test test test test ing test ing test This is a test string , asd asd asd asd , ";
//		Map<String, Integer> map = maxOccouranceOfWord(str);
//		System.out.println(map);
		List<Entry<String, Integer>> wordList = sortBywordcount(str);
		System.out.println(wordList);
	}
}
