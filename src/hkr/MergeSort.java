package hkr;

public class MergeSort {

	private static int inversions = 0;
	public static int[] mergeSort(int arr[]) {
		int tempArr[] = new int[arr.length];
		mergeSort(arr, tempArr, 0, arr.length-1);
		return tempArr;
	}

	public static void mergeSort(int arr[], int tempArr[], int left, int right) {
		if (left >= right) {
			return;
		}
		int middle = (left + right) / 2;
		mergeSort(arr, tempArr, 0, middle);
		mergeSort(arr, tempArr, middle+1, right);
		mergeHalves(arr, tempArr, left, right);

	}

	public static void mergeHalves(int arr[], int tempArr[], int leftStart, int rightEnd) {
		int invr = 0;
		
		int leftend = (leftStart + rightEnd) / 2;
		int rightStart = leftend + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftend && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				tempArr[index] = arr[left];
				left++;
			} else {
				tempArr[index] = arr[right];
				right++;
				invr++;
			}
			index++;
		}

		System.arraycopy(arr, left, tempArr, index, leftend - left + 1);
		System.arraycopy(arr, right, tempArr, index, rightEnd - right + 1);
		System.arraycopy(tempArr, leftStart, arr, leftStart, size);
		inversions+=invr;
	}

	public static void main(String[] args) {
		int arr[] = {2,1,3,1,2};
		int retarr[] = (mergeSort(arr));
		System.out.println(inversions);
	}
}
