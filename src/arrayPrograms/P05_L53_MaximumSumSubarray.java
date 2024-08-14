package arrayPrograms;

//Link: https://leetcode.com/problems/maximum-subarray/description/
//TimeComplexity: O(n)
//Type: Medium
public class P05_L53_MaximumSumSubarray {

	public static int findMaxSumSub(int nums[]) {
		int maxSum = nums[0];
		int currentSum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			currentSum += nums[i];
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
			if (currentSum < 0) {
				currentSum = 0;
			}

		}
//		for(int num:nums) {
//			currentSum+=num;
//			if(currentSum>maxSum) {
//				maxSum=currentSum;
//			}
//			
//			if(currentSum<0) {
//				currentSum=0;
//			}
//		}

		return maxSum;
	}

	public static int[] findMaxSubWithArray(int nums[]) {
		int maxSum = 0;
		int currentSum = 0, start = 0, end = 0, tempStart = 0;

		for (int i = 0; i < nums.length; i++) {
			currentSum += nums[i];
			if (currentSum > maxSum) {
				maxSum = currentSum;
				start = tempStart;
				end = i;
			}

			if (currentSum < 0) {
				currentSum = 0;
				tempStart = i + 1;
			}
		}

		int result[] = new int[end - start + 2];
		result[0] = maxSum;
		for (int i = start; i <= end; i++) {
			result[i - start + 1] = nums[i];
		}

		return result;
	}

	public static void main(String args[]) {
		int ar1[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int ar2[] = { 1 };
		int ar3[] = { 5, 4, -1, 7, 8 };

		System.out.println("maximum subarray sum for array1:" + findMaxSumSub(ar1));
		System.out.println("maximum subarray sum for array2:" + findMaxSumSub(ar2));
		System.out.println("maximum subarray sum for array3:" + findMaxSumSub(ar3));

	}

}
