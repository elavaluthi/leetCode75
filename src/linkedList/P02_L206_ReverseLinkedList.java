package linkedList;

//Link: https://leetcode.com/problems/reverse-linked-list/description/
//TimeComplexity: O(n)
//Type:Easy
public class P02_L206_ReverseLinkedList {
	
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
	
	public static ListNode reverseIteratively(ListNode head) {
		ListNode current=head;
		ListNode previous=null;
		
		while(current!=null) {
			ListNode next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		
		return previous;
	}
	
	public static ListNode reverseRecursively(ListNode head) {
		
		if(head==null||head.next==null) {
			return head;
		}
		
		ListNode newHead=reverseRecursively(head.next);
		head.next.next=head;
		head.next=null;
		return newHead;
		
	}
	
	public static void printList(ListNode head) {
		ListNode current=head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
	
	public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        // Reverse iteratively
        ListNode reversedIterative = reverseIteratively(head1);
        printList(reversedIterative);

        // Reset linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head2 = new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10)))));

        // Reverse recursively
        ListNode reversedRecursive = reverseRecursively(head2);
        printList(reversedRecursive);
    }
	
	

}
