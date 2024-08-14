package treePrograms;

//Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
//TimeComplexity: O(H + K) -> H is height of tree Worst case H can be O(n) for 
//balanced tree it will be O(log n)
//Type: Medium
public class P10_L230_KthSmallestBst {
	 int count = 0;
	 int result = -1;

	public int findKthSmallest(TreeNode root, int k) {
		inOrderTraversal(root, k);
		return result;
	}

	private void inOrderTraversal(TreeNode node, int k) {
		if (node == null)
			return;

		inOrderTraversal(node.left, k);
		count++;
		if (count == k) {
			result = node.val;
			return;
		}

		inOrderTraversal(node.right, k);
	}
	
	public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(6);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(2);
        P10_L230_KthSmallestBst solution1 = new P10_L230_KthSmallestBst();
        System.out.println(solution1.findKthSmallest(root1, 1));  // Output: 1

        // Example 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        P10_L230_KthSmallestBst solution2 = new P10_L230_KthSmallestBst();
        System.out.println(solution2.findKthSmallest(root2, 3));  // Output: 3
    }

}
