package treePrograms;

import java.util.*;

//Link: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
//Time complexity:O(n)
//Type: medium
public class P05_L102_LevelOrderTraversalBT {

	public static List<List<Integer>> travelLevelOrder(TreeNode root) {
		List<List<Integer>> finalResult = new ArrayList<>();

		if (root == null)
			return finalResult;
		Queue<TreeNode> queueData = new LinkedList<>();
		queueData.offer(root);

		while (!queueData.isEmpty()) {

			List<Integer> currentLevel = new ArrayList<>();
			int size = queueData.size();
			for (int i = 0; i < size; i++) {
				TreeNode currentNode = queueData.poll();
				currentLevel.add(currentNode.val);
				if (currentNode.left != null) {
					queueData.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queueData.offer(currentNode.right);
				}
			}
			finalResult.add(currentLevel);
		}

		return finalResult;
	}

	public static void main(String[] args) {
		// Create a sample tree: [3, 9, 20, null, null, 15, 7]
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<List<Integer>> result = travelLevelOrder(root);

		result.forEach(level -> System.out.println(level));
	}

}
