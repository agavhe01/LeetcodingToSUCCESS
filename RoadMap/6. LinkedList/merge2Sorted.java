/*

21. Merge Two Sorted Lists

Easy

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

*/



public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        
        /*

The code enters a while loop that runs as long as both l1 and l2 are not null. Inside the loop:

a. It compares the values of the current nodes l1.val and l2.val.

b. If l1.val is less than l2.val, it means that the next element in the merged list should come from l1. So, it assigns l1 as the next node of lastNode, and then updates l1 to point to its next node (l1 = l1.next).

c. If l2.val is less than or equal to l1.val, it means that the next element in the merged list should come from l2. So, it assigns l2 as the next node of lastNode, and then updates l2 to point to its next node (l2 = l2.next).

d. In either case (a or b), it updates lastNode to be the node that was just added to the merged list.

        */
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        
        /*

After the while loop finishes, one of the input lists (l1 or l2) may still have some elements remaining. So, the code checks if l1 is not null. If l1 is not null, it means there are remaining elements in l1, so it attaches the remaining portion of l1 to lastNode. Otherwise, if l1 is null, it attaches the remaining portion of l2 to lastNode.
        */
        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }
        
        return dummy.next;
    }
}