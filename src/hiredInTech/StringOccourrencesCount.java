package hiredInTech;


import java.util.Scanner;

public class StringOccourrencesCount {

    public static int[] constructLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int j = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j == 0) {
                    lps[i] = j;
                    i++;
                } else {
                    j = lps[j - 1];
                }

            }
        }
        return lps;
    }

    public static int matchPattern(String text, String pattern) {
        int result = 0;
        int[] lps = constructLPS(pattern);

        int j = 0;
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            if (j == pattern.length()) {
                result++;
                j = lps[j - 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stringT = sc.nextLine(); //"babalabalabalatheend"
        String stringP = sc.nextLine();//"alabala"

        System.out.println(matchPattern(stringT, stringP));

        sc.close();
    }
}
