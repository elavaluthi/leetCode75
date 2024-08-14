package linkedList;

//Link:https://leetcode.com/problems/reorder-list/description/
//Time Complexity: O(n)
//Type: Medium
public class P06_L143_ReorderList {

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void reorderList(ListNode head) {
		if(head==null||head.next==null) {
			return;
		}
		
		//1-2-3-4-5-6
		//Two find mid node
		ListNode slow=head,fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			//2-3-4-5-6,3-4-5-6,4-5-6
			fast=fast.next.next;
			//3-4-5-6,5-6,6
		}
		//slow=4-5-6
		//Reverse second half of the list
		ListNode prev=null,current=slow,temp;
		while(current!=null) {
			temp=current.next;
			current.next=prev;
			prev=current;
			current=temp;
		}
		
		//prev=6-5-4
		//first=1-2-3-4-5-6
		//merge both seocnd and first
		ListNode first=head,second=prev;
		while(second.next!=null) {
			temp=first.next;
			first.next=second;
			first=temp;
			
			temp=second.next;
			second.next=first;
			second=temp;
		}
		
	}
	
	 public static void main(String[] args) {

	        // Example 1
	        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
	        reorderList(head1);
	        printList(head1); // Output: 1 4 2 3

	        // Example 2
	        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
	        reorderList(head2);
	        printList(head2); // Output: 1 5 2 4 3
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
