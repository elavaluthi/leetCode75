package arrayPrograms;

//Link: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
//Time Complexity: O(logn)
//Type: Medium
public class P08_L33_SearchRotatedSortArray {

	public static int findTargetRotatedSort(int nums[], int target) {

		int left = 0;
		int right = nums.length - 1;
		// 4,5,6,7,0,1,2
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target)
				return mid;

			if (nums[left] <= nums[mid]) {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else
					right = mid - 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		
		int nums[]= {4,5,6,7,0,1,2};
		int target=1;
		
		System.out.println("target found at index:"+findTargetRotatedSort(nums, target));

	}

}
