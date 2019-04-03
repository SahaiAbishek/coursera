package lc;

import java.util.Stack;

public class SimplifyPath {

	public static String simplifyPath(String path) {
		StringBuffer result = new StringBuffer();
		Stack<String> stack = new Stack<>();
		String[] dir = path.split("/");
		// StringTokenizer tokens = new StringTokenizer(path, "/");
		// while(tokens.hasMoreTokens()){
		// System.out.println(tokens.nextToken());
		// }
		int len = dir.length - 1;
		int i = 0;
		while (i <= len) {
			if (dir[i].trim().length() > 0) {
				if (dir[i].equals("..")) {
					if (!stack.isEmpty()) {
						stack.pop();
					}
				} else {
					if (!dir[i].equals(".")) {
						stack.push(dir[i]);
					}
				}
			}
			i++;
		}
		if (stack.isEmpty()) {
			return "/";
		}
		for (i = 0; i < stack.size(); i++) {
			result.append("/");
			result.append(stack.get(i));
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(simplifyPath("/a//b////c/d//././/.."));
	}

}
