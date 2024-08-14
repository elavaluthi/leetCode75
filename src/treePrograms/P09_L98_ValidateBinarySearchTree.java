package treePrograms;

//Link: https://leetcode.com/problems/validate-binary-search-tree/description/
//TimeComplexity: O(n)
//Type: Medium
public class P09_L98_ValidateBinarySearchTree {

	public static boolean isValidBst(TreeNode root) {
		return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public static boolean isValidBst(TreeNode node, long lower, long upper) {

		if (node == null) {
			return true;
		}

		if (node.val <= lower || node.val >= upper) {
			return false;
		}

		return isValidBst(node.left, lower, node.val) && isValidBst(node.right, node.val, upper);
	}
	
	 public static void main(String[] args) {
	        	        
	        // Example 1
	        TreeNode root1 = new TreeNode(2);
	        root1.left = new TreeNode(1);
	        root1.right = new TreeNode(3);
	        System.out.println(isValidBst(root1)); // Output: true
	        
	        // Example 2
	        TreeNode root2 = new TreeNode(5);
	        root2.left = new TreeNode(1);
	        root2.right = new TreeNode(4);
	        root2.right.left = new TreeNode(3);
	        root2.right.right = new TreeNode(6);
	        System.out.println(isValidBst(root2)); // Output: false
	    }
}
