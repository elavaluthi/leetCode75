package treePrograms;

//Link: https://leetcode.com/problems/same-tree/description/
//TimeComplexity: O(n)
//Type:Easy
public class P02_L100_SameTress {

	public static boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;

		return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

	}
	
	public static void main(String[] args) {
        // Example 1
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println(isSameTree(p1, q1)); // Output: true

        // Example 2
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println(isSameTree(p2, q2)); // Output: false

        // Example 3
        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);
        p3.right = new TreeNode(1);

        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(1);
        q3.right = new TreeNode(2);

        System.out.println(isSameTree(p3, q3)); // Output: false
    }
}
