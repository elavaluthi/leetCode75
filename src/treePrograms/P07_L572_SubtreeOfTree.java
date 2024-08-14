package treePrograms;

//Link: https://leetcode.com/problems/subtree-of-another-tree/description/
//Timecomplexity: O(n*m) n number of nodes in root m number of nodes in subRoot
//Type: Easy
public class P07_L572_SubtreeOfTree {

	public static boolean isSubTree(TreeNode root, TreeNode subRoot) {
		if (root == null)
			return false;
		if (isSameTree(root, subRoot)) {
			return true;
		}

		return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
	}

	public static boolean isSameTree(TreeNode x, TreeNode y) {
		if (x == null && y == null) {
			return true;
		}
		if (x == null || y == null) {
			return false;
		}

		return (x.val == y.val) && isSameTree(x.left, y.left) && isSameTree(x.right, y.right);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);

		TreeNode subRoot = new TreeNode(4);
		subRoot.left = new TreeNode(1);
		subRoot.right = new TreeNode(2);

		System.out.println(isSubTree(root, subRoot)); // Output: true

		root.left.right.left = new TreeNode(0);
		System.out.println(isSubTree(root, subRoot)); // Output: false
	}
}
