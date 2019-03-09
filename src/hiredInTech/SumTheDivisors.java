package hiredInTech;

public class SumTheDivisors {
    public static long sum_the_divisors(int number) {
        if(number == 1){
            return 1;
        }
        if(number == 2){
            return 3;
        }
        if(number == 3){
            return 4;
        }
        long result = 0;
        int len = (int)Math.sqrt(number);
        int i = 1;
        while (i <= len) {
            if(number % i == 0){
                result+=i;
                result +=number/i;
            }
            i++;
        }
        if(len*len == number){
            result-=len;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sum_the_divisors(16));
    }
}
