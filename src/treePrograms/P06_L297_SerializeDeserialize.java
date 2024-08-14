package treePrograms;

import java.util.*;

//Link:https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
//TimeComplexity: O(n)
//Type: hard

public class P06_L297_SerializeDeserialize {

	public static String serialize(TreeNode root) {
		if (root == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }

        // Remove trailing nulls and commas
        while (sb.length() > 1 && sb.substring(sb.length() - 5).equals("null,")) {
            sb.setLength(sb.length() - 5); // Remove "null,"
        }

        sb.setLength(sb.length() - 1); // Remove the last comma
        sb.append("]");
        
        return sb.toString();
	}

	public static TreeNode deSerialize(String data) {
		if (data == "[]") {
			return null;
		}

		String[] nodes = data.substring(1, data.length() - 1).split(",");
		TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
		Queue<TreeNode> queueData = new LinkedList<>();
		queueData.add(root);

		int index = 1;

		while (!queueData.isEmpty()) {
			TreeNode current = queueData.poll();
			if (index < nodes.length && !nodes[index].equals("null")) {
				current.left = new TreeNode(Integer.parseInt(nodes[index]));
				queueData.add(current.left);
			}		
			index++;
			if (index < nodes.length && !nodes[index].equals("null")) {
				current.right = new TreeNode(Integer.parseInt(nodes[index]));
				queueData.add(current.right);
			}
			index++;
		}
		return root;
	}

	public static void main(String[] args) {

		// Create a sample tree: [1, 2, 3, null, null, 4, 5]
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		// Serialize the tree
		String serialized = serialize(root);
		System.out.println("Serialized: " + serialized);

		// Deserialize the string back to tree
		TreeNode deserialized = deSerialize(serialized);

		// Serialize the deserialized tree to check if it matches the original
		// serialization
		String serializedAgain = serialize(deserialized);
		System.out.println("Serialized Again: " + serializedAgain);

		// Check if both serializations are equal
		assert serialized.equals(serializedAgain) : "Error: The tree was not deserialized correctly!";
	}
}
