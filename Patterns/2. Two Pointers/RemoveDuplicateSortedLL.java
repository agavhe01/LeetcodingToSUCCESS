/**
 * Leetcode ; 83. Remove Duplicates from Sorted List

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 
class RemoveDuplicateSortedLL {

    public boolean isDuplicate(ListNode a, ListNode b){
        return a.val == b.val;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val != temp.next.val) {
                temp = temp.next; //current and the next nodes are distinct
            } else {
                temp.next = temp.next.next; //skip if the next node is duplicate
            }
        }
        return head;
    }
}
