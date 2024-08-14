package slidingWindow;

import java.util.HashSet;

//Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//Time Complexity = O(n)
//abcabc
public class P1_L3_LongestSubstring {
	
	public static int lengthOfLongestSubstring(String str) {
		int size=str.length();
		int start=0,end=0,longest=0;
		
		HashSet<Character> set= new HashSet<>();
		
		while(end<size) {
			if(!set.contains(str.charAt(end))) {
				set.add(str.charAt(end));
				end++;
				longest=Math.max(longest, (end-start));
			}else {
				set.remove(str.charAt(start));
				start++;
			}
		}
		return longest;
	}
	
	public static void main(String args[]) {
		String name="abdulmajeeth";
		System.out.println("Longest substring length:"+lengthOfLongestSubstring(name));
	}

}
