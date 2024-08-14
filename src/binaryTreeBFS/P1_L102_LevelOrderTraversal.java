package binaryTreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Link: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
//Time complexity: O(n)
public class P1_L102_LevelOrderTraversal {
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(){}
		TreeNode(int val){
			this.val=val;
		}
		TreeNode(int val, TreeNode left, TreeNode right){
			this.val=val;
			this.left=left;
			this.right=right;
		}
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> result=new ArrayList<>();
		
		if(root==null) {
			return result;
		}
		
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			List<Integer> currentLevel=new ArrayList<>();
			int queueSize=queue.size();
			
			for(int i=0;i<queueSize;i++) {
				TreeNode currentNode=queue.poll();
				currentLevel.add(currentNode.val);
				if(currentNode.left!=null) {
					queue.offer(currentNode.left);
				}
				if(currentNode.right!=null) {
					queue.offer(currentNode.right);
				}
			}
			
			result.add(currentLevel);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
        // Create a sample tree: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(root);

        result.forEach(level->System.out.println(level));
    }

}
