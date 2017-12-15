package cci;

public class MatrixToZero {

	public void setZeros(int[][] arr) {
		if (arr == null) {
			throw new NullPointerException();
		}

		int[] rows = new int[arr.length];
		int[] cols = new int[arr[0].length];

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] == 0) {
					rows[row] = 1;
					cols[col] = 1;
				}
			}

		}

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if(rows[row] == 1){
					arr[row][col] = 0;
				}
				if(cols[col] == 1){
					arr[row][col] = 0;
				}
			}
		}

		print(arr);
	}

	public void print(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(" " + arr[row][col]);
			}
			System.out.println();
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 0 }, { 4, 5, 6 }, { 7, 0, 9 }, };
		MatrixToZero m = new MatrixToZero();
		System.out.println("Initil matrix");
		m.print(arr);
		
		System.out.println("New Matrix");
		m.setZeros(arr);
	}

}
