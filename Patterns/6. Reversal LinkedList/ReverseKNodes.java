/**
 * LEETCODE: 25 25. Reverse Nodes in k-Group

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

 
class Solution {

    public boolean isKandListEqual(ListNode head, int k){
        
        while(k != 0 && head != null){
            head = head.next;
            k--;
        }

        return k == 0;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(k==1) return head;
        if(!isKandListEqual(head,k)) return head; 
        
        int count = 0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode forward = null;

        while(curr != null && count < k){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
            count++;
        }

        /*
        Here, it's checking if there are more than k nodes left in the list (i.e., forward is not null). 
        If there are, it means there are more groups of k nodes further down the list. 
        In this case, it recursively calls reverseKGroup on the forward node to...
           reverse the next group of k nodes and then connects the head of the current group to the result of reversing the next group.
        */

        if(forward != null){
            head.next = reverseKGroup(forward,k);
        }

        return prev;
    }
}