package treePrograms;

//Link:https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
//Time Complexity:O(n) -> n is number of node
//Type:Hard
public class P04_L124_MaximumPathSumBT {
	private static int maxSum;
	
	public static int maxPathSum(TreeNode node) {
		maxSum = Integer.MIN_VALUE;
		dfs(node);
		return maxSum;
	}

	public static int dfs(TreeNode node) {

		if (node == null)
			return 0;

		int left = Math.max(dfs(node.left), 0);
		int right = Math.max(dfs(node.right), 0);

		maxSum = Math.max(maxSum, (node.val + left + right));
		
		return node.val+Math.max(left, right);
	}
	
	// Example usage
    public static void main(String[] args) {
    	
    	// Construct the binary tree for example 1
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);

        
        System.out.println("Maximum Path Sum (Example 1): " + maxPathSum(root2)); // Output: 42
        
        // Construct the binary tree for example 2
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        
        
        System.out.println("Maximum Path Sum (Example 2): " + maxPathSum(root1)); // Output: 6

        
    }
	
	
	

}
