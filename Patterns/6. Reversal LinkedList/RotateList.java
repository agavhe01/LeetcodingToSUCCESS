/**

Leetcode: 61 Rotate List

Given the head of a linked list, rotate the list to the right by k places.


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }



     The following is a solution in O(n) time and O(1) space
    _______________________________________________________

class Solution {

     public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null)    {return head; }

        ListNode curr = head;
        int length = 1;

        while(curr.next != null) {
            curr = curr.next;
            length++;
        }

        curr.next = head;
        k = k % length;
        k = length - k;
        while(k>0)  {curr = curr.next; k--;}

        head = curr.next;
        curr.next = null;

        return head;
    }
}

    _______________________________________________________
 * }
 */


class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null){ return head; }

        if (k == 0){ return head; }

        ArrayList<ListNode> nodes = new ArrayList<>();

        ListNode temp = head;

        int count = 0;
        while(temp != null){
            nodes.add(temp);
            count++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);

       Collections.rotate(nodes, k);

       dummy.next = nodes.get(0);

       ListNode prev = dummy.next;


       for(int i = 1; i < count; i++){
           temp = nodes.get(i);
           prev.next = temp;
           prev = temp;
       }

       
        prev.next = null;
        return dummy.next;
        
    }
}