package binarySearch;

//Link: https://leetcode.com/problems/search-a-2d-matrix/description/
//TimeComplexity:O(log(m*n));
//Type:Medium
public class P06_L74_SearchSortedMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null||matrix.length==0||matrix[0].length==0) {
			return false;
		}
		
		int m=matrix.length;
		int n=matrix[0].length;
		int left=0;
		int right=m*n-1;
		
		while(left<=right) {
			int mid=left+(right-left)/2;
			int midValue=matrix[mid/n][mid%n];
			
			if(midValue==target) {
				return true;
			}else if(midValue<target) {
				left=mid+1;
			}else
				right=mid-1;
		}
		
		return false;
	}
	
	public static void main(String[] args) {

        int[][] matrix1 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target1 = 3;
        System.out.println(searchMatrix(matrix1, target1)); // Output: true

        int[][] matrix2 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target2 = 13;
        System.out.println(searchMatrix(matrix2, target2)); // Output: false
    }

}
