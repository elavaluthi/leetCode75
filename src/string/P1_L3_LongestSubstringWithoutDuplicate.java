package string;

import java.util.*;

//Link:https://leetcode.com/problems/longest-substring-without-repeating-characters/
//TimeComplexity: O(n)
//Type: Medium
public class P1_L3_LongestSubstringWithoutDuplicate {
	
	public static int findLongestSubstring(String str) {
		//str="abdulmajeeth";abccb
		int size=str.length();
		int left=0,right=0,longest=0;
		HashSet<Character> setValues=new HashSet<>();
		
		while(right<size) {
			if (setValues.contains(str.charAt(right))) {
    setValues.remove(str.charAt(left));
    left++;
} else {
    setValues.add(str.charAt(right));
    right++;
    longest = Math.max(longest, (right - left));
}
			
		}
		
		return longest;
	}
	
	public static void main(String[] args) {
			String str1="abdulmajeeth";
			String str2="abcabdmk";
			
			System.out.println("first string result:"+findLongestSubstring(str1));
			System.out.println("second string result:"+findLongestSubstring(str2));
	}

}
