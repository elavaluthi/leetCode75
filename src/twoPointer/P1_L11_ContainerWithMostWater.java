package twoPointer;

//https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
//time complexity is O(n):

public class P1_L11_ContainerWithMostWater {
	
	    public static int maxArea(int[] height) {
	    	int left = 0;
	        int right = height.length - 1;
	        int maxArea = 0;

	        while (left < right) {
//	        	System.out.println("\n");
//	        	System.out.println("left:"+left+" right:"+right);
	        	int width = right - left;
//	        	System.out.println("width:"+width);
//	        	System.out.println("array values:"+height[left] +" "+height[right]);
	            int area = Math.min(height[left], height[right]) * width;
//	            System.out.println("area:"+area);
	            maxArea = Math.max(maxArea, area);
//	            System.out.println("maxArea:"+maxArea);

	            // Move the pointer pointing to the shorter line inward
	            if (height[left] < height[right]) {
	                left++;
	            } else {
	                right--;
	            }
	        }

	        return maxArea;        
	    }
	    
	    public static void main(String[] args) {
	        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
	        int[] height2 = {1, 1};

	        System.out.println("out:"+maxArea(height1));  // Output: 49
	        System.out.println("out"+maxArea(height2));  // Output: 1
	    }
	    
	    

}
