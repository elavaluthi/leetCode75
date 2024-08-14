package string;

import java.util.*;
//Link:https://leetcode.com/problems/valid-parentheses/description/
//TimeComplexity:O(n)
//Type:Easy
public class P6_L20_ValidParentheses {

	public static boolean isValidParantheses(String str) {
		if(str.length()%2!=0) {
			return false;
		}
		
		Map<Character, Character> valueMap=new HashMap<>();
		valueMap.put(')','(');
		valueMap.put('}','{');
		valueMap.put(']','[');
		
		Stack<Character> valueStack=new Stack<>();
		
		for(char c:str.toCharArray()) {
			if(valueMap.containsKey(c)) {
				char topElement=valueStack.isEmpty() ? '#':valueStack.pop();
				if(valueMap.get(c)!=topElement) {
					return false;
				}
			}else
				valueStack.add(c);
		}
		
		return valueStack.isEmpty();
		
	}
	
	public static void main(String args[]) {
		String str1="(){}[]";
		String str2="()[";
		String str3="()]";
		
		System.out.println("validation result for str1:"+isValidParantheses(str1));
		System.out.println("validation result for str2:"+isValidParantheses(str2));
		System.out.println("validation result for str3:"+isValidParantheses(str3));
	}
}
