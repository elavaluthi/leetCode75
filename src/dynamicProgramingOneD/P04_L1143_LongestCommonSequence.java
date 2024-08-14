package dynamicProgramingOneD;

//Link: https://leetcode.com/problems/longest-common-subsequence/description/
//TimeComplexity: O(n*m)
//Type: Medium
public class P04_L1143_LongestCommonSequence {

	public static int findLongCommon(String str1, String str2) {

		int n = str1.length();
		int m = str2.length();

		int dp[][] = new int[n + 1][m + 1];

		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=m; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[n][m];
	}
	
	public static void main(String[] args) {
        
        
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(findLongCommon(text1, text2)); // Output: 3

        text1 = "abc";
        text2 = "abc";
        System.out.println(findLongCommon(text1, text2)); // Output: 3

        text1 = "abc";
        text2 = "def";
        System.out.println(findLongCommon(text1, text2)); // Output: 0
    }
}
