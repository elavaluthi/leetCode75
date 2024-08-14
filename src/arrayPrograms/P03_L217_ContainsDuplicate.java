package arrayPrograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Link: https://leetcode.com/problems/contains-duplicate/description/
public class P03_L217_ContainsDuplicate {

	//TimeComplexity: O(n)
	public static boolean containsDuplicate(int[] nums) {

		Set<Integer> setValues = new HashSet<>();

		for (int num : nums) {
			if (!setValues.add(num))
				return true;
		}

		return false;
	}

	//TimeComplexity: O(n^2)
	public static boolean containsDuplicateBruteForce(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] == nums[j])
					return true;
			}
		}
		return false;
	}
	
	//TimeComplexity: O(nlogn)
	public static boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        
        System.out.println(containsDuplicate(nums1)); // Output: true
        System.out.println(containsDuplicate(nums2)); // Output: false
        System.out.println(containsDuplicate(nums3)); // Output: true
    }
}
