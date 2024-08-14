package linkedList;

//Link: https://leetcode.com/problems/merge-two-sorted-lists/description/

//Time Complexity: O(n+m);
//Type: Easy
public class P01_L21_MergeTwoSortedList {
	 static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public  static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to act as the start of the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // If one of the lists is not empty, append the rest of the nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // The merged list is next to the dummy node
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
    	
        // Example 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList = mergeTwoLists(list1, list2);
        System.out.print("Example 1: ");
        printList(mergedList); // Output: [1, 1, 2, 3, 4, 4]

        // Example 2
        list1 = null;
        list2 = null;
        mergedList = mergeTwoLists(list1, list2);
        System.out.print("Example 2: ");
        printList(mergedList); // Output: []

        // Example 3
        list1 = null;
        list2 = new ListNode(0);
        mergedList = mergeTwoLists(list1, list2);
        System.out.print("Example 3: ");
        printList(mergedList); // Output: [0]
    }
}
