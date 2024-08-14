package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Link: https://leetcode.com/problems/valid-parentheses/description/
//TimeComplexity: O(n)

public class P1_L20_ValidParantheses {
	
	public static boolean isValid(String str) {
		
		if(str.length()%2 != 0) {
			return false;
		}
		
		Map<Character, Character> pairValues=new HashMap<>();
		pairValues.put(')','(');
		pairValues.put('}','{');
		pairValues.put(']','[');
		
		Stack<Character> stack=new Stack<>();
		
		for(char c:str.toCharArray()) {
			if(pairValues.containsKey(c)) {
				char topElement=stack.isEmpty()? '#' :stack.pop();
				if(topElement != pairValues.get(c)) {
					return false;
				}
			}else {
				stack.push(c);
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String args[]) {
		String str1="(){}[]";
		String str2="()[]";
		String str3="()]";
		
		System.out.println("validation result for str1:"+isValid(str1));
		System.out.println("validation result for str2:"+isValid(str2));
		System.out.println("validation result for str3:"+isValid(str3));
	}

}
