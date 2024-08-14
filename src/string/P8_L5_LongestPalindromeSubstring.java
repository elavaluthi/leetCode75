package string;

//Link:https://leetcode.com/problems/longest-palindromic-substring/description/
//TimeComplexity: O(n^2)
//Type:Medium
public class P8_L5_LongestPalindromeSubstring {

	public static String findLongestPalindrome(String str) {
		if (str == null || str.length() < 1)
			return "";

		int start = 0, end = 0;

		for (int i = 0; i < str.length(); i++) {
			int len1 = expandAroundCenter(str, i, i);
			int len2 = expandAroundCenter(str, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}

		return str.substring(start, end + 1);

	}

	public static int expandAroundCenter(String str, int left, int right) {

		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}

		return right - left - 1;

	}

	public static void main(String[] args) {

		String s1 = "babad";
		System.out.println(findLongestPalindrome(s1)); // Output: "bab" or "aba"

		String s2 = "cbbd";
		System.out.println(findLongestPalindrome(s2)); // Output: "bb"
	}

}
