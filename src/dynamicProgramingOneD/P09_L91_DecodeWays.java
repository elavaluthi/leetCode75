package dynamicProgramingOneD;

//Link:https://leetcode.com/problems/decode-ways/description/
//TimeComplexity:O(n), SpaceComplexity:O(n)
//Type=Medium
public class P09_L91_DecodeWays {

	public static int decodeWays(String s) {
		
		if(s==null||s.length()==0||s.charAt(0)=='0') {
			return 0;
		}
		int n=s.length();
		int dp[]=new int[n+1];
		
		dp[0]=1;
		dp[1]=1;
		
		for(int i=2;i<=n;i++) {
			int oneDigit=Integer.parseInt(s.substring(i-1, i));
			int twoDigit=Integer.parseInt(s.substring(i-2, i));
			
			if(oneDigit>=1) {
				dp[i]+=dp[i-1];
			}
			
			if(twoDigit>=10&&twoDigit<=26) {
				dp[i]+=dp[i-2];
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		
	        // Test cases
	        System.out.println("Input: \"12\" | Output: " + decodeWays("12")); // Output: 2
	        System.out.println("Input: \"226\" | Output: " + decodeWays("226")); // Output: 3
	        System.out.println("Input: \"06\" | Output: " + decodeWays("06")); // Output: 0
	        System.out.println("Input: \"11106\" | Output: " + decodeWays("11106")); // Output: 2
	        System.out.println("Input: \"0\" | Output: " + decodeWays("0")); // Output: 0
	        System.out.println("Input: \"10\" | Output: " + decodeWays("10")); // Output: 1
	    
	}

}
