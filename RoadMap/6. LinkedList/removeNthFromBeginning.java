/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
   
    public ListNode removeNthFromBeginning(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        
        if (n == 1) {
            return head.next;
        }
        
        ListNode prev = null;
        ListNode current = head;
        int count = 1;
        

        /*
We use a while loop to iterate through the linked list and count nodes until we reach the (n-1)-th node from the beginning. 
This is because we want to remove the nth node, and prev should be pointing to the node just before it.
        */
        while (current != null && count < n) {
            prev = current;
            current = current.next;
            count++;
        }
        

        /*
Once the loop completes, we check if current is not null. 
If current is not null, it means there are at least n nodes in the list, and prev is pointing to the (n-1)-th node from the beginning. 
In this case, we update the next reference of prev to skip over current, effectively removing the nth node from the list.
        */
        if (current != null) {
            prev.next = current.next;
        }
        
        return head;
    }
}
