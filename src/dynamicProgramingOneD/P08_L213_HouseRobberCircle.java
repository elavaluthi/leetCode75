package dynamicProgramingOneD;

public class P08_L213_HouseRobberCircle {
	
	public static int finRob(int nums[]) {
		if(nums.length==1)
			return nums[0];
		
		int max1=robLinear(nums,0,nums.length-2);
		int max2=robLinear(nums, 1, nums.length-1);
		
		return Math.max(max1, max2);
	}
	
	private static int robLinear(int nums[], int start, int end) {
		if(start==end)
			return nums[start];
		
		int prev1=0;
		int prev2=0;
		
		for(int i=start;i<=end;i++) {
			int temp=prev1;
			prev1=Math.max(prev1, prev2+nums[i]);
			prev2=temp;
		}
		return prev1;
	}
	
	 public static void main(String[] args) {
	                
	        // Test cases
	        int[] nums1 = {2, 3, 2};
	        System.out.println(finRob(nums1)); // Output: 3
	        
	        int[] nums2 = {1, 2, 3, 1};
	        System.out.println(finRob(nums2)); // Output: 4
	        
	        int[] nums3 = {1, 2, 3};
	        System.out.println(finRob(nums3)); // Output: 3
	    }

}
