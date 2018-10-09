/**
 * Related to bit manipulation
 * XOR the number with itself will give zero
 */

package hkr;

public class LonelyInt {

	public static int lonelyInteger(int[] a) {
		int retval = a[0];
		for (int i = 1; i < a.length; i++) {
			retval ^= a[i];
		}
		return retval;
	}

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int a[] = new int[n];
//		for (int a_i = 0; a_i < n; a_i++) {
//			a[a_i] = in.nextInt();
//		}
//		System.out.println(lonelyInteger(a));
		int a[] = {3,3,1,2,1};
		System.out.println(lonelyInteger(a));
		
	}

}
