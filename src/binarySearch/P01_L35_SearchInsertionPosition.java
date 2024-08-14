package binarySearch;

//Link:https://leetcode.com/problems/search-insert-position
//TimeComplexity:O(logn);
//Type: Medium
//ChatGpt Link: https://chatgpt.com/share/953727be-9e75-40e4-8c35-f9a861ea74b4
public class P01_L35_SearchInsertionPosition {

	public static int findInsertionPosition(int nums[], int target) {

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}

	public static void main(String[] args) {

		int[] nums1 = { 3, 5, 6, 7, 9 };
		int target1 = 1;
		System.out.println(findInsertionPosition(nums1, target1)); // Output: 0

		int[] nums2 = { 1, 3, 5, 6 };
		int target2 = 3;
		System.out.println(findInsertionPosition(nums2, target2)); // Output: 1

		int[] nums3 = { 1, 3, 5, 6 };
		int target3 = 7;
		System.out.println(findInsertionPosition(nums3, target3)); // Output: 4
	}

}
