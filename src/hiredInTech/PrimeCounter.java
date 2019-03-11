/*
A classic math task is to count the prime numbers less than or equal to some integer number N. In this task you have to write a function,
which does this for a given N, where 1 <= N <= 10^6. We don't count 1 a prime.

Here are a few examples:

For N=10, the prime numbers, which are less than or equal to 10 are: 2, 3, 5, 7. The function must return 4. For N=31,
 the prime numbers are: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31. The function must return 11.
 */

package hiredInTech;

public class PrimeCounter {

    public static int prime_counting(int n) {
        if (n == 1) {
            return 0;
        }
        boolean[] isMarked = new boolean[n + 1];
        int result = 0;
        for (int i = 2; i <= n; i++) {
            if (!isMarked[i]) {
                result++;
            }

            int count = 2;
            int j = i * count;
            while (j <= n) {
                isMarked[j] = true;
                count++;
                j = i * count;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println("\nTotal => " + prime_counting(31));
    }
}
