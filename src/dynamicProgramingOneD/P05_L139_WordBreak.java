package dynamicProgramingOneD;

import java.util.*;

//Link:https://leetcode.com/problems/word-break/description/
//TimeComplexity:O(n^2)
//Type: Medium
public class P05_L139_WordBreak {

	public static boolean findWord(String s, List<String> wordDictionary) {

		Set<String> setDictionary = new HashSet<>(wordDictionary);

		boolean dp[] = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && setDictionary.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}

	public static void main(String[] args) {

		String s1 = "leetcode";
		List<String> wordDict1 = Arrays.asList("leet", "code");
		System.out.println(findWord(s1, wordDict1)); // true

		String s2 = "applepenapple";
		List<String> wordDict2 = Arrays.asList("apple", "pen");
		System.out.println(findWord(s2, wordDict2)); // true

		String s3 = "catsandog";
		List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
		System.out.println(findWord(s3, wordDict3)); // false
	}
}
