package hkr;

import java.util.Arrays;

public class NonPairNumber {

	public static int func(int a[]) {
		if (a.length == 1) {
			return a[0];
		}
		
		Arrays.sort(a);

		for (int i = 1; i < a.length; i += 2) {
			int j = i - 1;
			if (a[i] != a[j]) {
				if (a[j] == a[j + 1]) {
					return a[i];
				} else {
					return a[j];
				}
			}
		}

		return a[a.length - 1];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 2, 3, 3, 3, 5 };
		System.out.println(func(arr));
	}

}
