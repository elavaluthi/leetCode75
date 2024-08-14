package treePrograms;

import binaryTree.P1_L104_MaximumDepthBT.TreeNode;

public class P01_L104_MaximumDepthBT {

	public static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

	}

	public static int findMaxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = findMaxDepth(root.left);
		int right = findMaxDepth(root.right);

		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
        // Create a sample tree: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(findMaxDepth(root));  // Output: 3
    }

}
