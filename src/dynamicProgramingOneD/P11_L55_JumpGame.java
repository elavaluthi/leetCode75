package dynamicProgramingOneD;

//Link:https://leetcode.com/problems/jump-game/description/
//Time Complexity: O(n)
public class P11_L55_JumpGame {
	
	public static boolean canJump(int nums[]) {
		
		int maxReach=0;
		
		for(int i=0;i<nums.length;i++) {
			if(i>maxReach) {
				return false;
			}
			
			maxReach=Math.max(maxReach, (i+nums[i]));
		}
		return true;
	}
	
	public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums1)); // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2)); // Output: false
    }

}
