package string;

//Link:https://leetcode.com/problems/palindromic-substrings/description/
//TimeComplexity: O(n^2)
//Type:Medium
public class P9_L647_PalindromeSubstring {

	public static int findPalindrome(String str) {
		int size=str.length();
		int count=0;
		
		for(int i=0;i<size;i++) {
			count+=expandFromCenter(str, i, i);
			count+=expandFromCenter(str, i, i+1);
		}
		return count;
		
	}
	
	private static int expandFromCenter(String str, int left, int right) {
		int count=0;
		
		while(left>=0&&right<str.length()&&str.charAt(left)==str.charAt(right)) {
			count++;
			left--;
			right++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(findPalindrome(s1)); // Output: 3

        String s2 = "aaa";
        System.out.println(findPalindrome(s2)); // Output: 6
    }
}
