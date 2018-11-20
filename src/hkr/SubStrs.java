package hkr;

import java.util.ArrayList;
import java.util.List;

public class SubStrs {

	public static List<String> findSustrsofLen(String str, int len) {
		List<String> retList = new ArrayList<>();
		for (int i = 0; i < str.length() - len + 1; i++) {
			String subString = str.substring(i, i + len);
			// check for duplicates in substring
			boolean[] b = new boolean[256];
			for (int j = 0; j < len; j++) {
				int index = subString.charAt(j);
				if (b[index]) {
					break;
				} else {
					b[index] = true;
				}
				if (j == len - 1) {
					if (!retList.contains(subString)) {
						retList.add(subString);
					}
				}
			}
		}
		return retList;
	}

	public static void main(String[] args) {
		List<String> list = findSustrsofLen("abcabc", 3);
		for (String val : list) {
			System.out.println(val);
		}
	}

}
