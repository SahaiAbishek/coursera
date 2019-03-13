/*
his is a classic task requiring you to count all integer factors of a positive integer number N,
including 1 and the number itself. Note that this is not just about the prime factors but all of them.

For example for 12 there are 6 such factors: 1, 2, 3, 4, 6, 12.
 */

package hiredInTech;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class CountNumbersFactors {
    public static int count_numbers_factors(long number) {
        int factorCount = 1;
        Map<Long,Integer> map = all_prime_factors(number);
        Set<Map.Entry<Long, Integer>> entries = map.entrySet();
        for(Map.Entry<Long,Integer> entry: entries){
            int num = entry.getValue()+1;
            factorCount = factorCount*num;
        }
        return factorCount;
    }

    public static Map<Long, Integer> all_prime_factors(long number) {
        Map<Long, Integer> result = new HashMap<>();

        while (number > 1) {
            boolean isPrime = true;
            for (long i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    if (result.containsKey(i)) {
                        int val = result.get(i);
                        result.put(i, val + 1);
                    } else {
                        result.put(i, 1);
                    }
                    number = number / i;
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                if (result.containsKey(number)) {
                    int val = result.get(number);
                    result.put(number, val + 1);
                } else {
                    result.put(number, 1);
                }
                number /= number;
            }
        }
        return result;
    }

    public  static void main(String[] args){
        System.out.println(count_numbers_factors(1));
    }

}
