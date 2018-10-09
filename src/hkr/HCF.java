package hkr;

public class HCF {

	public static int generalizedGCD(int first, int second) {
		if (first == 0) {
			return second;
		}
		return generalizedGCD(second % first, first);
	}

	public static int generalizedGCD(int num, int[] arr) {
		int result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result = generalizedGCD(result, arr[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 6, 8, 10 };
		System.out.println(generalizedGCD(5, arr));
	}
}
