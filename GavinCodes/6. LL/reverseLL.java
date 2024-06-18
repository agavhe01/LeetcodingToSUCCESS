/**

206. Reverse Linked List
Solved
Easy
Topics
Companies
Given the head of a singly linked list, reverse the list, and return the reversed list.

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

    // recursive is faster 
    public ListNode reverseList(ListNode head) { return reverse(head, null); }

    public ListNode reverse(ListNode root, ListNode prev){
        if (root == null) return prev;
        ListNode temp = root.next;
        root.next = prev;
        return reverse(temp, root);
    }
}



/*

Alternate solution

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;

        while(head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        return newHead;


        
    }
}

*/