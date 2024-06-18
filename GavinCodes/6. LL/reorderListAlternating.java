/**


Solved
Medium
Topics
Companies
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode middle = findMiddle(head);
        // System.out.println(middle.val);
        ListNode tail = reverseList(middle.next);
        // System.out.println(tail.val);
        middle.next = null;
        head = merge(head, tail);
  
    }

    public ListNode reverseList(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // ListNode slow2 = head;
        // while(slow2.next != null && slow2 != slow){
        //     slow2 = slow2.next;
        // }
        // return slow2;
        return slow;
    }

    public ListNode merge(ListNode head1, ListNode head2){
        int count = 0;
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;

        while(head1 != null && head2 != null){
            if (count % 2 == 0){
                dummy.next = head1;
                head1 = head1.next;
            }
            else{
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            count++;
        }

        if (head1 != null) dummy.next = head1; 
        else dummy.next = head2;
        return newHead.next;
    }
}