package binarySearch;

//Link:https://leetcode.com/problems/find-peak-element/description
//TimeComplexity: O(logn)
//Type:Medium



public class P02_L162_FindPeakElement {

	public static int findPeakElement(int nums[]) {
		int left = 0;
		int right = nums.length - 1;
		
		// A peak element is an element that is strictly greater than its neighbors.
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[mid + 1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums1)); // Output: 2

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums2)); // Output: 5 (or 1, as both are valid peaks)
    }
}
