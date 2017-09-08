package hkr;

public class Anagram {

	public static int numberNeeded(String first, String second) {
		
		int count = 0;
		for (int i = 0; i < first.length(); i++) {
			String str = first.charAt(i)+"";
			if(second.contains(str)){
				count+=2;
				second = second.replace(str, "");
			}
			
		}
		return first.length()+second.length() - count;
	}

	public static void main(String[] args) {
		System.out.println(numberNeeded("bacdc", "dcbad"));
	}

}
