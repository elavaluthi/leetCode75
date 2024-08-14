package treePrograms;

//Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
//TimeComplexity:
//Type: Medium
public class P11_L235_LowestCommonAnchester {

	public static TreeNode findLowestCommonAnchester(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode currentNode = root;

		while (currentNode != null) {

			if (p.val > currentNode.val && q.val > currentNode.val) {
				currentNode = currentNode.right;
			}

			if (p.val < currentNode.val && q.val < currentNode.val) {
				currentNode = currentNode.left;
			} else {
				return currentNode;
			}
		}

		return null;
	}

	public static void main(String[] args) {
		// Example 1
		TreeNode root1 = new TreeNode(6);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(8);
		root1.left.left = new TreeNode(0);
		root1.left.right = new TreeNode(4);
		root1.right.left = new TreeNode(7);
		root1.right.right = new TreeNode(9);
		root1.left.right.left = new TreeNode(3);
		root1.left.right.right = new TreeNode(5);

		TreeNode p1 = root1.left; // Node with value 2
		TreeNode q1 = root1.right; // Node with value 8

		TreeNode lca1 = findLowestCommonAnchester(root1, p1, q1);
		System.out.println("LCA of nodes " + p1.val + " and " + q1.val + " is: " + lca1.val);

		// Example 2
		TreeNode p2 = root1.left; // Node with value 2
		TreeNode q2 = root1.left.right; // Node with value 4

		TreeNode lca2 = findLowestCommonAnchester(root1, p2, q2);
		System.out.println("LCA of nodes " + p2.val + " and " + q2.val + " is: " + lca2.val);

		// Example 3
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);

		TreeNode p3 = root2; // Node with value 2
		TreeNode q3 = root2.left; // Node with value 1

		TreeNode lca3 = findLowestCommonAnchester(root2, p3, q3);
		System.out.println("LCA of nodes " + p3.val + " and " + q3.val + " is: " + lca3.val);
	}
}
