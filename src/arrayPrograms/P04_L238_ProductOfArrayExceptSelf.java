package arrayPrograms;

//Link:https://leetcode.com/problems/product-of-array-except-self/description/
//Time Complexity: O(n)
//Type:Medium
public class P04_L238_ProductOfArrayExceptSelf {

	public static int[] productExceptSelf(int nums[]) {
		int size=nums.length;
		int answer[]=new int[size];
		
		answer[0]=1;
		//multiple left element with its left value.. 
		//for first left element the left value will be 1
		for(int i=1;i<size;i++) {
			answer[i]=answer[i-1]*nums[i-1];
		}
		
		//nums{1,2,3,4}
		//answer{1,1,2,6}
		
		int R=1;
		//multiple right element with its right value.. 
		//for first right element the right value will be 1
		for(int i=size-1;i>=0;i--) {
			answer[i]=answer[i]*R;
			R*=nums[i];
		}
		//R=1,4,12,24
		//answer{24,12,8,6}
		
		return answer;
	}
	
	public static void main(String[] args) {
        
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};
        
        int[] result1 = productExceptSelf(nums1);
        int[] result2 = productExceptSelf(nums2);
        
        // Output: [24, 12, 8, 6]
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Output: [0, 0, 9, 0, 0]
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
}
