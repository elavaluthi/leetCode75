package treePrograms;

import java.util.LinkedList;
import java.util.Queue;

public class P03_L226_InvertBinaryTree {

	public static TreeNode invertTree(TreeNode root) {

		if (root == null)
			return null;

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}

	public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("[");
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                System.out.print(current.val + " ");
                queue.add(current.left);
                queue.add(current.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println("]");
    }
	
	public static void main(String[] args) {
        

        // Example 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        System.out.println("Original tree (In-order traversal):");
        printTree(root1);
        root1 = invertTree(root1);
        System.out.println("\nInverted tree (In-order traversal):");
        printTree(root1);

        // Example 2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        System.out.println("\n\nOriginal tree (In-order traversal):");
        printTree(root2);
        root2 = invertTree(root2);
        System.out.println("\nInverted tree (In-order traversal):");
        printTree(root2);

        // Example 3
        TreeNode root3 = null;

        System.out.println("\n\nOriginal tree (In-order traversal):");
        printTree(root3);
        root3 = invertTree(root3);
        System.out.println("\nInverted tree (In-order traversal):");
        printTree(root3);
    }
}
