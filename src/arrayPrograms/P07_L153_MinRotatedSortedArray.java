package arrayPrograms;

//Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
//Time Complexity: O(n)
//Type: Medium
public class P07_L153_MinRotatedSortedArray {
	
	public static int findMinRotate(int nums[]) {
		
		if(nums==null||nums.length==0) {
			throw new IllegalArgumentException("Input array is null or empty");
		}
		
		int left=0;
		int right=nums.length-1;
		
		while(left<right) {
			int mid=left+(right-left)/2;
			
			if(nums[mid]>nums[right]) {
				left=mid+1;
			}else
				right=mid;
		}
		
		return nums[left];
	}
	
	public static void main(String args[]) {
		int ar1[]= {3,4,5,1,2};
		int ar2[]= {4,5,6,7,0,1,2};
		int ar3[]= {11,13,15,17};
		
		System.out.println("Min value in array 1:"+findMinRotate(ar1));
		System.out.println("Min value in array 2:"+findMinRotate(ar2));
		System.out.println("Min value in array 3:"+findMinRotate(ar3));
	}


}
