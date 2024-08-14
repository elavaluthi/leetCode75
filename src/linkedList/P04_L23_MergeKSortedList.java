package linkedList;


import java.util.PriorityQueue;

//Link:https://leetcode.com/problems/merge-k-sorted-lists/
//Time Complexity: O(nlogk) k-number of list, n-size of linkedlist
//Type: Hard
public class P04_L23_MergeKSortedList {
	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) 
        	return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Using traditional for loop
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode mergedList = mergeKLists(lists);

        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}

