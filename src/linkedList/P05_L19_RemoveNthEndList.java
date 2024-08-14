package linkedList;

import linkedList.P02_L206_ReverseLinkedList.ListNode;

//Link:https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
//Time Complexity: O(n)
//Type: Medium
public class P05_L19_RemoveNthEndList {
	
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
	
	public static ListNode removeNode(ListNode head, int n) {
		//1-2-3-4-5
		ListNode dummy=new ListNode(0,head);
		printList(dummy);
		ListNode first=dummy;
		ListNode second=dummy;
		
		// Move first n+1 steps ahead
		for(int i=0;i<=n;i++) {
			first=first.next;
		}
		
		// Move both first and second pointers until first reaches the end
		while(first!=null) {
			first=first.next;
			second=second.next;
		}
		
		// Move both first and second pointers until first reaches the end
		second.next=second.next.next;
		
		return dummy.next;
		
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		printList(head);
		ListNode result=removeNode(head,2);
		printList(result);
		
	}

	public static void printList(ListNode head) {
		ListNode current=head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
