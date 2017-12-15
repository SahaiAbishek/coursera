package cci;

public class AnagramChecker {

	public static boolean isAnagram(String str1, String str2) {

		int arr[] = new int[26];

		for (int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) == ' '){
				continue;
			}
			int val = str1.charAt(i) - 'a';
			int currentval = arr[val];
			currentval++;
			arr[val] = currentval;
		}
		
		for (int i = 0; i < str2.length(); i++) {
			if(str2.charAt(i) == ' '){
				continue;
			}
			int val = str2.charAt(i) - 'a';
			int currentval = arr[val];
			currentval--;
			arr[val] = currentval;
		}

		int sum=0;
		for(int num : arr){
			sum = sum+num;
		}
		
		if(sum != 0){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "railsafety";
		String str2 = "fairytales";
		System.out.println(isAnagram(str1, str2));
	}
}
