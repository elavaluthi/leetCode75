package linkedList;


//Link:https://leetcode.com/problems/linked-list-cycle/description/
//Time complexity:O(n)
//Type: Easy
public class P03_L141_cycleList {
	
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode() {		}
		public ListNode(int val) {
			this.val=val;
		}
		public ListNode(int val, ListNode next) {
			this.val=val;
			this.next=next;
		}	
	}
	
	public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
	
	
	    public static void main(String[] args) {
	        // Example 1: Create a linked list [3,2,0,-4] with a cycle at position 1
	        ListNode head1 = new ListNode(3);
	        ListNode node2 = new ListNode(2);
	        ListNode node3 = new ListNode(0);
	        ListNode node4 = new ListNode(-4);
	        head1.next = node2;
	        node2.next = node3;
	        node3.next = node4;
	        node4.next = node2;  // cycle here

	        
	        System.out.println("Example 1: " + hasCycle(head1));  // Output: true

	        // Example 2: Create a linked list [1,2] with a cycle at position 0
	        ListNode head2 = new ListNode(1);
	        ListNode node5 = new ListNode(2);
	        head2.next = node5;
	        node5.next = head2;  // cycle here

	        System.out.println("Example 2: " + hasCycle(head2));  // Output: true

	        // Example 3: Create a linked list [1] with no cycle
	        ListNode head3 = new ListNode(1);

	        System.out.println("Example 3: " + hasCycle(head3));  // Output: false

	        // Example 4: Create an empty linked list
	        ListNode head4 = null;

	        System.out.println("Example 4: " + hasCycle(head4));  // Output: false
	    }
	


}
