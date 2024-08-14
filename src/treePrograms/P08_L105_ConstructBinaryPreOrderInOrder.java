package treePrograms;

import java.util.*;

//Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
//TimeComplexity:O(n)
//Type:Medium
public class P08_L105_ConstructBinaryPreOrderInOrder {

	public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
		HashMap<Integer, Integer> inMapValues = new HashMap<>();
		for (int i = 0; i < inOrder.length; i++) {
			inMapValues.put(inOrder[i], i);
		}
		return buildTreeHelper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, inMapValues);

	}

	public static TreeNode buildTreeHelper(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart,
			int inEnd, HashMap<Integer, Integer> inMapValues) {

		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		int rootValue = preOrder[preStart];
		TreeNode root = new TreeNode(rootValue);
		int inRootIndex = inMapValues.get(rootValue);
		int leftTreeSize = inRootIndex - inStart;

		root.left = buildTreeHelper(preOrder, preStart + 1, preStart + leftTreeSize, inOrder, inStart, inRootIndex - 1,
				inMapValues);
		root.right = buildTreeHelper(preOrder, preStart + 1 + leftTreeSize, preEnd, inOrder, inRootIndex + 1, inEnd,
				inMapValues);
		return root;
	}

	private static void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		TreeNode root = buildTree(preorder, inorder);
		printTree(root);
	}

}
