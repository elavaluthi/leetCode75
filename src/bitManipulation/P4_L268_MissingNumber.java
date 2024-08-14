package bitManipulation;

//Link:https://leetcode.com/problems/missing-number/description/
//TimeComplexity:O(n)
public class P4_L268_MissingNumber {

	public static int findMissingNumber(int nums[]) {
		
		int size=nums.length;
		int expectedSum=size*(size+1)/2;
		int actualSum=0;
		for(int num:nums) {
			actualSum+=num;
		}
		
		return expectedSum-actualSum;
	}
	
	public static void main(String[] args) {
        int[] nums1 = {3, 0, 1};
        System.out.println("Missing number: " + findMissingNumber(nums1)); // Output: 2

        int[] nums2 = {0, 1};
        System.out.println("Missing number: " + findMissingNumber(nums2)); // Output: 2

        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing number: " + findMissingNumber(nums3)); // Output: 8
    }
	
	
}
