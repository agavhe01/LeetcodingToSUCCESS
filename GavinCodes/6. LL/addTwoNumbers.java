/**

2. Add Two Numbers
Solved
Medium
Topics
Companies
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int q = 0;
        int r = 0;
        int sum = 0;

        ListNode temp = null;
        ListNode head = null;

        while (l1 != null || l2 != null || q > 0){
            sum = ((l1 == null) ? 0 : l1.val) +
                  ((l2 == null) ? 0 : l2.val) + 
                  q;

            q = sum / 10;
            r = sum % 10;

            ListNode newNode = new ListNode(r);

            if (head == null){
                head = newNode;
                temp = head;
            }
            else{
                temp.next = newNode;
                temp = newNode;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
        return head;
    }
}