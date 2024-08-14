package arrayPrograms;

import java.util.*;

//Link:https://leetcode.com/problems/3sum/description/
//Time complexity: O(n^2)
//Type: Medium
public class P09_L15ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums); // Sort the array to facilitate two-pointer technique

		// Iterate through the array
		for (int i = 0; i < nums.length; i++) {
			// Skip duplicate values of nums[i] to avoid duplicate triplets
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			// Initialize two pointers, j starting just after i and k at the end of the
			// array
			int j = i + 1;
			int k = nums.length - 1;

			// Use two pointers approach to find pairs that sum up to -nums[i]
			while (j < k) {
				int total = nums[i] + nums[j] + nums[k];

				if (total > 0) {
					// If the sum is greater than 0, decrement k to reduce the total
					k--;
				} else if (total < 0) {
					// If the sum is less than 0, increment j to increase the total
					j++;
				} else {
					// If the total is zero, we found a triplet
					res.add(Arrays.asList(nums[i], nums[j], nums[k]));

					// Skip over duplicate values of nums[j]
					while (j < k && nums[j] == nums[j + 1]) {
						j++;
					}
					while (j < k && nums[k] == nums[k - 1]) {
						k--;
					}

					j++;
					k--;
				}
			}
		}

		return res; // Return the list of unique triplets
	}

	public static void main(String[] args) {

		int[] nums1 = { -1, 0, 1, 2, -1, -4 }; // -4,-1,-1,0,1,2
		System.out.println(threeSum(nums1)); // Output: [[-1,-1,2],[-1,0,1]]

		int[] nums2 = { 0, 1, 1 };
		System.out.println(threeSum(nums2)); // Output: []

		int[] nums3 = { 0, 0, 0 };
		System.out.println(threeSum(nums3)); // Output: [[0,0,0]]
	}
}

/*
 * nums = [-4, -1, -1, 0, 1, 2] Breakdown of Valid Triplets Triplet 1: [-1, -1,
 * 2] Indices: 1, 2, 5 Sum: -1 + (-1) + 2 = 0 Triplet 2: [-1, 0, 1] Indices: 1,
 * 3, 4 Sum: -1 + 0 + 1 = 0
 */
