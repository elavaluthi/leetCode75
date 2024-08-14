package arrayPrograms;

//Link: https://leetcode.com/problems/maximum-product-subarray/
//TimeComplexity: O(n)
public class P06_L152_MaximumProductSubArray {
	
	public static int findMaxProdSub(int nums[]) {
		
		int maxProduct=nums[0];
		int minProduct=nums[0];
		int result=nums[0];
		
		for(int i=1;i<nums.length;i++) {
			int current=nums[i];
			if(current<0) {
				int temp=maxProduct;
				maxProduct=minProduct;
				minProduct=temp;
			}
			
			maxProduct=Math.max(current, maxProduct*current);
			minProduct=Math.min(current, minProduct*current);
			
			result=Math.max(result,maxProduct);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};

        System.out.println(findMaxProdSub(nums1)); // Output: 6
        System.out.println(findMaxProdSub(nums2)); // Output: 0
    }

}
