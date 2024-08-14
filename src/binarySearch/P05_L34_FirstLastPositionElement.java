package binarySearch;

import java.util.Arrays;

//Link:https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description
//TimeComplexity: O(logn)
//Type: Medium
public class P05_L34_FirstLastPositionElement {

	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = findTargetIndex(nums, target, true);
		result[1] = findTargetIndex(nums, target, false);
		return result;
	}

	public static int findTargetIndex(int[] nums, int target, boolean findLeft) {

		int left = 0;
		int right = nums.length - 1;
		int index = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				index = mid;
				if (findLeft) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			}
		}

		return index;
	}

	public static void main(String[] args) {

		int[] nums1 = { 5, 7, 7, 8, 8, 10 };
		int target1 = 8;
		System.out.println(Arrays.toString(searchRange(nums1, target1))); // Output: [3, 4]

		int[] nums2 = { 5, 7, 7, 8, 8, 10 };
		int target2 = 6;
		System.out.println(Arrays.toString(searchRange(nums2, target2))); // Output: [-1, -1]

		int[] nums3 = {};
		int target3 = 0;
		System.out.println(Arrays.toString(searchRange(nums3, target3))); // Output: [-1, -1]
	}
}
