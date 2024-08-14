package dynamicProgramingOneD;

//Link:https://leetcode.com/problems/house-robber/description/
//TimeComplexity:O(n)
public class P07_L198_HouseRobber {
	
	public static int rob(int nums[]) {
		if(nums==null)
			return 0;
		if(nums.length==0)
			return nums[0];
		
		int prev1=0,prev2=0;
		
		for(int i=0;i<nums.length;i++) {
			int temp = prev1;
            prev1 = Math.max(prev1,prev2 + nums[i]);
            prev2 = temp;
		}
		return prev1;
	}

	public static void main(String[] args) {


        // Example 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Maximum amount that can be robbed: " + rob(nums1)); // Output: 4

        // Example 2
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Maximum amount that can be robbed: " + rob(nums2)); // Output: 12
    }
}
