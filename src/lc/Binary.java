package lc;

public class Binary {

	public static String addBinary(String a, String b) {
		String result = "";
		int l1 = a.length() - 1;
		int l2 = b.length() - 1;

		char sum = '0';
		char carry = '0';
		while (l1 >= 0 && l2 >= 0) {
			char c1 = a.charAt(l1);
			char c2 = b.charAt(l2);
			if (c1 == '1' && c2 == '1' && carry == '1') {
				sum = '1';
				carry = '1';
			} else if (c1 == '1' && c2 == '1' && carry == '0') {
				sum = '0';
				carry = '1';
			} else if ((c1 == '0' && c2 == '1' && carry == '1') || (c1 == '1' && c2 == '0' && carry == '1')) {
				sum = '0';
				carry = '1';
			} else if ((c1 == '0' && c2 == '1' && carry == '0') || (c1 == '1' && c2 == '0' && carry == '0')) {
				sum = '1';
				carry = '0';
			} else if (c1 == '0' && c2 == '0' && carry == '1') {
				sum = '1';
				carry = '0';
			} else if (c1 == '0' && c2 == '0' && carry == '0') {
				sum = '0';
				carry = '0';
			}
			result = result + sum;
			l1--;
			l2--;
		}

		while (l1 >= 0) {
			char c1 = a.charAt(l1);
			if (c1 == '1' && carry == '1') {
				sum = '0';
				carry = '1';
			} else if (c1 == '0' && carry == '1') {
				sum = '1';
				carry = '0';
			} else if (c1 == '0' && carry == '0') {
				sum = '0';
				carry = '0';
			} else if (c1 == '0' && carry == '1') {
				sum = '1';
				carry = '0';
			} else if (c1 == '1' && carry == '0') {
				sum = '1';
				carry = '0';
			}
			result = result + sum;
			l1--;
		}

		while (l2 >= 0) {
			char c2 = b.charAt(l2);
			if (c2 == '1' && carry == '1') {
				sum = '0';
				carry = '1';
			} else if (c2 == '0' && carry == '1') {
				sum = '1';
				carry = '0';
			} else if (c2 == '0' && carry == '0') {
				sum = '0';
				carry = '0';
			} else if (c2 == '0' && carry == '1') {
				sum = '1';
				carry = '0';
			} else if (c2 == '1' && carry == '0') {
				sum = '1';
				carry = '0';
			}
			result = result + sum;
			l2--;
		}
		if (carry == '1') {
			result = result + carry;
		}
		String rev = "";
		for (int i = result.length() - 1; i >= 0; i--) {
			rev = rev + result.charAt(i);
		}
		return rev;
	}

	public static void main(String[] args) {
		System.out.println(addBinary("100", "110010"));
	}
}
