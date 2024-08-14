package dynamicProgramingOneD;

//Link:https://leetcode.com/problems/climbing-stairs/description/
//TimeComplexity:O(n)
//Type: Easy
public class P01_L70_ClimbingStairs {

	public 	static int findClimbingStairs(int n) {
		if(n<=0) {
			return 0;
		}
		
		if(n==1) {
			return 1;
		}
		
		int dp[]=new int[n+1];
		dp[1]=1;
		dp[2]=2;
		
		for(int i=3;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
        
        System.out.println(findClimbingStairs(2)); // Output: 2
        System.out.println(findClimbingStairs(3)); // Output: 3
    }
}
