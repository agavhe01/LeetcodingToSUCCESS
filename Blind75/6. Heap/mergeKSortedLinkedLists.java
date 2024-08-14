// TC: O(n * log k), SC: O(k)

import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (!minHeap.isEmpty()) {
            ListNode tmp = minHeap.poll();
            curr.next = tmp;
            curr = curr.next;
            if (tmp.next != null) {
                minHeap.add(tmp.next);
            }
        }
        return head.next;
    }
} 