package cci;

public class ReplaceSpaceInString {
	
	public static void main(String[] args) {
		String str = "Abhi shek Sahai";
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<str.length();i++){
			char c = str.charAt(i);
			if(c == ' '){
				sb.append("%20");
			}else{
				sb.append(c);
			}
		}
		
		str = sb.toString();
		System.out.println(str);
	}

}
