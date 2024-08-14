package binarySearch;

//Link :https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
//TimeComplexity:O(logn)
//Type:Medium
//ChatGptLink: https://chatgpt.com/share/74393ac6-f6fa-40aa-af1b-caa06fc5bc8d
public class P03_L153_MinRotatedSortArray {
	// {3,4,5,1,2}, {5,1,2,3,4}
	public static int finMinRotate(int nums[]) {
		if (nums == null || nums.length == 0) {
			throw new IllegalArgumentException("Input array is null or empty");
		}

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			System.out.println("mid:" + mid);

			/*
			 * If the middle element is greater than the element at the right pointer, the
			 * minimum element must be to the right of mid.
			 * 
			 * Otherwise, the minimum element is at mid or to the left of mid.
			 */
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else if (nums[mid] <= nums[right])
				right = mid;
		}

		return nums[left];
	}

	public static void main(String args[]) {
		int ar1[] = { 3, 4, 5, 1, 2 };
		int ar2[] = { 4, 5, 6, 7, 0, 1, 2 };
		int ar3[] = { 11, 13, 15, 17 };

		System.out.println("Min value in array 1:" + finMinRotate(ar1));
		System.out.println("Min value in array 2:" + finMinRotate(ar2));
		System.out.println("Min value in array 3:" + finMinRotate(ar3));
	}

}
