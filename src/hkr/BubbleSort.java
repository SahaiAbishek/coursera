package hkr;

public class BubbleSort {

	public static void bubbleSort(int arr[]) {

		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			int len = arr.length - 1;
			for (int i = 0; i < len; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					isSorted = false;
				}

			}
			len++;
		}
		// print the sorted array
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(+arr[i] + ":");
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		int arr[] = { 4, 3, 1, 2, 5 };
		bubbleSort(arr);
	}

}
