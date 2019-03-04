package hiredInTech;

public class FractionSimplification {

    public static void simplify_fraction(int numerator, int denominator, int[] result) {
        int gcd = calculateGDC(numerator, denominator);
        result[0] = gcd == 1 ? numerator : numerator / gcd;
        result[1] = gcd == 1 ? denominator : denominator / gcd;
    }

    public static int calculateGDC(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return denominator;
        }
        numerator = numerator % denominator;
        return calculateGDC(denominator, numerator);
    }

    public static void main(String args[]) {
        int[] res = new int[2];
        simplify_fraction(24, 8, res);
        System.out.println(res[0] + " : " + res[1]);
    }
}
