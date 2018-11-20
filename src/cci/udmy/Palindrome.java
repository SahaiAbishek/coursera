package cci.udmy;

public class Palindrome {

	public static boolean isPalindrome(String s) {
		 s = s.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");
			s = s.replaceAll(" ", "");
	        
	        if(s.equals("") ){
	            return true;
	        }
		
			int start = 0;
			int end = s.length() - 1;
			while (start < end) {
				if(s.charAt(start) != s.charAt(end)){
					return false;
				}
				start++;
				end--;
			}
			return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("race a car"));
	}
}
