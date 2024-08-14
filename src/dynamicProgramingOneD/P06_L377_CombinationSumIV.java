package dynamicProgramingOneD;

//link:https://leetcode.com/problems/combination-sum-iv/description/
//TimeComplexity:O(target * n)
//Type: Medium
public class P06_L377_CombinationSumIV {

	public static int findMaxCombination(int nums[], int target) {
		int dp[] = new int[target + 1];
		dp[0] = 1;

		for (int i = 1; i <= target; i++) {
			for (int num : nums) {
				if (i - num >= 0) {
					dp[i] = dp[i] + dp[i - num];
				}
			}
		}
		return dp[target];
	}
	
	public static void main(String[] args) {
        

        int[] nums1 = {1, 2, 3};
        int target1 = 4;
        System.out.println(findMaxCombination(nums1, target1));  // Output depends on the implementation of usageLimit

        int[] nums2 = {9};
        int target2 = 3;
        System.out.println(findMaxCombination(nums2, target2));  // Output depends on the implementation of usageLimit
    }
}
