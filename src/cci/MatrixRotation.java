package cci;

public class MatrixRotation {

	public static int[] convertToArr(int[][] arr2D) {

		int len = arr2D.length;
		int arr[] = new int[len * len];
		for (int row = 0; row < len; row++) {
			for (int col = 0; col < len; col++) {
				int pos = (row * len + col);
				arr[pos] = arr2D[row][col];
			}
		}
		return arr;

	}

	public void rotateMatrix(int[] arr,int len) {

	}

	public static void main(String[] args) {

		int arr2D[][] = { { 1, 2, 3, }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] arr1d = convertToArr(arr2D);
		for (int num : arr1d) {
			System.out.print(num + " : ");
		}
	}

}
