package arrayPrograms;

import java.util.HashMap;
import java.util.Map;

//Link: https://leetcode.com/problems/two-sum/description/
//Time Complexity: O(n)

public class P01_L1_TwoSum {
	
	public static int[] findTwoSum(int nums[],int target) {
		Map<Integer,Integer> elementMap= new HashMap<>();
		int result[]=new int[2];
		
		for(int i=0; i<nums.length; i++) {
			int complement=target-nums[i];
			if(elementMap.containsKey(complement)) {
				result[1]=i;
				result[0]=elementMap.get(complement);
				return result;
			}
			elementMap.put(nums[i], i);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// Example 1
		int[] nums1 = { 2, 7, 11, 15 };
		int target1 = 9;
		int[] result1 = findTwoSum(nums1, target1);
		System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");

		// Example 2
		int[] nums2 = { 3, 2, 4 };
		int target2 = 6;
		int[] result2 = findTwoSum(nums2, target2);
		System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");

		// Example 3
		int[] nums3 = { 3, 3 };
		int target3 = 6;
		int[] result3 = findTwoSum(nums3, target3);
		System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]");
	}
}
