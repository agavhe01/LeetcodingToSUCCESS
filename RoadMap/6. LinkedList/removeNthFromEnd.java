class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        
        /*
A for loop is used to advance the fast pointer n nodes ahead in the linked list. 
This positions the fast pointer n nodes ahead of the slow pointer.
        */
        for (int i = 0; i < n; i++) fast = fast.next;

        /*
If fast is null, it means that n is equal to the length of the linked list. 
In this case, we need to remove the first node from the list. So, the code returns head.next, effectively removing the first node.
        */
        if (fast == null) return head.next;



        /*
Once the fast pointer reaches the end of the list (fast.next == null), 
the slow pointer will be pointing to the node that precedes the node to be removed (the (n-1)-th node from the end).
        */
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        /*
To remove the nth node from the end, the code updates the next reference of the slow pointer to skip over the nth node,
effectively removing it from the list.
        */
        slow.next = slow.next.next;
        return head;
    }
}