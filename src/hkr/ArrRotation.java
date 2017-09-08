package hkr;

public class ArrRotation {

	public static int[] arrayLeftRotation(int[] a, int n, int k) {

		int j = 0;
		int tmpArr[] = new int[n];
		for (int i = k; i < n; i++) {
			tmpArr[j++] = a[i];
		}

		for (int i = 0; i < k; i++) {
			tmpArr[j++] = a[i];
		}
		return tmpArr;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		int n = 5;
		int k = 4;
		a = arrayLeftRotation(a, n, k);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");
	}

}
