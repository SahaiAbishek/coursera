package hkr;

public class PrimeNumber {

	public static void checkPrime(int num) {
		int sqrt = (int) Math.sqrt(num);
		boolean isPrime = true;

		if (num == 1) {
			System.out.println("Not prime");
			return;
		}
		if (num == 2) {
			System.out.println("Prime");
			return;
		}

		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				System.out.println("Not prime");
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println("Prime");
		}
	}

	public static void main(String[] args) {
		checkPrime(1);
	}

}
