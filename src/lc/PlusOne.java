package lc;

public class PlusOne {

	public static int[] plusOne(int[] digits) {

		int carry = 0;
		int count = digits.length - 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int num = carry + digits[i];
			if (i == digits.length - 1) {
				num += 1;
			}

			if (num > 9) {
				num = num % 10;
				carry = 1;
			} else {
				carry = 0;
			}
			digits[count--] = num;
		}
		if (carry > 0) {
			int result[] = new int[digits.length + 1];
			result[0] = carry;

			return result;

		}
		return digits;
	}

	public static void main(String[] args) {
		int[] num = { 9,9 };
		num = plusOne(num);
		for (int n : num)
			System.out.print(" " + n);
	}

}
