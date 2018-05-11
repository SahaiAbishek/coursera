package hkr;

public class SecondHighest {

	public static void secondHighest(int arr[]) {
		if (null == arr || arr.length == 0) {
			System.out.println("Empty of null arrray");
			return;
		}
		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if(num > highest){
				secondHighest = highest;
				highest = num;
			}else if(num > secondHighest){
				secondHighest = num;
			}
		}
		System.out.println("Highest = " + highest);
		System.out.println("Second highest = " + secondHighest);
	}

	public static void main(String[] args) {
		int arr[] = { 20, 15, 1, 5, 6, 12, 21 };
		secondHighest(arr);
	}

}
