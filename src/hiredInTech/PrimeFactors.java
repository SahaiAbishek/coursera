package hiredInTech;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public static List<Long> all_prime_factors(long number) {
        // Write your code here:
        List<Long> result = new ArrayList<>();

        while (number > 1) {
            boolean isPrime = true;
            for (long i = 2; i <= Math.sqrt(number); i++) {
                if(number % i == 0){
                    result.add(i);
                    number = number/i;
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                result.add(number);
                number /= number;
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(all_prime_factors(9001));
    }
}
