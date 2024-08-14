package dynamicProgramingOneD;

import java.util.Arrays;

//Link: https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
//TimeComplexity: O(nlogn)
//Type: Medium
public class P03_L300_LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int maxLength = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }


        return maxLength;
    }

    //O(n Log n)
    public static int lengthOfLISBinary(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int length = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, length, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == length) {
                length++;
            }
        }

        return length;
    }
    
    public static void main(String[] args) {
        
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums1));  // Output: 4
        
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums2));  // Output: 4
        
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(nums3));  // Output: 1
    }
}
